/* Help configure the state-base ui.router */
(function () {
    'use strict';

    angular
        .module('blocks.router')
        .provider('routerHelper', routerHelperProvider);

    routerHelperProvider.$inject = ['$locationProvider', '$stateProvider', '$urlRouterProvider'];
    /* @ngInject */
    function routerHelperProvider($locationProvider, $stateProvider, $urlRouterProvider) {
        /* jshint validthis:true */
        var config = {
            docTitle: undefined,
            resolveAlways: {}
        };

        $locationProvider.html5Mode(false).hashPrefix('!');

        this.configure = function (cfg) {
            angular.extend(config, cfg);
        };

        this.$get = RouterHelper;
        RouterHelper.$inject = ['$location', '$rootScope', '$state'];
        /* @ngInject */
        function RouterHelper($location, $rootScope, $state) {
            var handlingStateChangeError = false;
            var hasOtherwise = false;
            var stateCounts = {
                errors: 0,
                changes: 0
            };

            var service = {
                configureStates: configureStates,
                getStates: getStates,
                stateCounts: stateCounts
            };

            init();

            return service;

            ///////////////

            function configureStates(states, otherwisePath) {
                /*jshint loopfunc: true */
                var sameStateUrl = [];
                states.forEach(function (state) {
                    state.config.resolve = angular.extend(state.config.resolve || {}, config.resolveAlways);
                    if (state.config && state.config.url && angular.isArray(state.config.url)) {
                        sameStateUrl.push({
                            sameAs: state.state,
                            urls: state.config.url.slice(1)
                        });
                        state.config.url = state.config.url[0];
                    }
                    $stateProvider.state(state.state, state.config);
                });
                if (otherwisePath && !hasOtherwise) {
                    hasOtherwise = true;
                    $urlRouterProvider.otherwise(otherwisePath);
                }
                if (sameStateUrl.length > 0) {
                    var tmp;
                    for (var i in sameStateUrl) {
                        for (var j in sameStateUrl[i].urls) {
                            $urlRouterProvider.when(sameStateUrl[i].urls[j], ['$state', '$match', function ($state, $match) {
                                $state.go(sameStateUrl[i].sameAs);
                            }]);
                        }
                    }
                }
            }


            function handleRoutingErrors() {
                // Route cancellation:
                // On routing error, go to the dashboard.
                // Provide an exit clause if it tries to do it twice.
                $rootScope.$on('$stateChangeError',
                    function (event, toState, toParams, fromState, fromParams, error) {
                        if (handlingStateChangeError) {
                            return;
                        }
                        stateCounts.errors++;
                        handlingStateChangeError = true;
                        var destination = (toState &&
                            (toState.title || toState.name || toState.loadedTemplateUrl)) ||
                            'desconhecida';
                        var msg = 'Erro ao obter a funcionalidade ' + destination + '. ' +
                            (error.data || '') + '. <br/>' + (error.statusText || '') +
                        ': ' + (error.status || '');
                        //logger.warning("Não foi possível obter o caminho requistiado.");
                        //logger.log(msg, [toState]);
                        //$location.path('/');
                    }
                );
            }

            function init() {
                handleRoutingErrors();
                updateDocTitle();
            }

            function getStates() { return $state.get(); }

            function updateDocTitle() {
                $rootScope.$on('$stateChangeSuccess',
                    function (event, toState, toParams, fromState, fromParams) {
                        stateCounts.changes++;
                        handlingStateChangeError = false;
                        //var routeTitle = toState.title || toState.ncyBreadcrumb.label || '';
                        var title = config.docTitle;
                        $rootScope.title = title; // data bind to <title>
                    }
                );
            }
        }
    }
})();
