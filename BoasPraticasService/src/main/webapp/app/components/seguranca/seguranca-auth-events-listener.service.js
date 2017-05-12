(function () {
    'use strict';

    angular
        .module('app.seguranca')
        .factory('segurancaAuthEventsListener', segurancaAuthEventsListener);

    segurancaAuthEventsListener.$inject = ['$rootScope', '$timeout', 'seguranca', 'AUTH_EVENTS'];
    /* @ngInject */
    function segurancaAuthEventsListener($rootScope, $timeout, seguranca, AUTH_EVENTS) {
        var service = {
            inicializar: inicializar
        };

        return service;

        function inicializar() {
            $rootScope.$on('$stateChangeStart', onStateChangeStart);
        }

        function onStateChangeStart(event, toState, toParams) {
            if (toState.data && toState.data.requireAuthorization) {
                if (seguranca.authenticated) {
                    var autorizado = false;
                    var recurso = '';
                    if (toState.data.permission) {
                        recurso = String(toState.data.permission.resource || '').trim();
                        if (recurso.length > 0) {
                            var permissions = seguranca.getPermission(recurso);
                            autorizado = permissions.hasPermission(toState.data.permission.level || 15);
                        }
                    }

                    if (!autorizado) {
                        event.preventDefault();
                        $timeout(function () {
                            $rootScope.$broadcast(AUTH_EVENTS.notAuthorized, { state: toState });
                        });
                    }
                }
                else {
                    event.preventDefault();
                    $timeout(function () {
                        $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated, { state: toState });
                    });
                }
            }
        }
    }
})();