(function () {
    'use strict';

    angular
        .module('app.seguranca')
        .factory('segurancaHttpInterceptorService', segurancaHttpInterceptorService);

    segurancaHttpInterceptorService.$inject = ['$q', '$injector'];
    /* @ngInject */
    function segurancaHttpInterceptorService($q, $injector) {
        var apiRegExp = /^\/?api\//i;
        return {
            request: function (config) {
                if (apiRegExp.test(config.url)) {
                    config.headers['X-Requested-With'] = 'XMLHttpRequest';
                    if (!('Authorization' in config.headers)) {
                        var security = $injector.get('seguranca');
                        if (security && security.token)
                            config.headers.Authorization = 'Bearer ' + security.token;
                    }
                }
                return config || $q.when(config);
            },
            responseError: function (response) {
                var AUTH_EVENTS = $injector.get('AUTH_EVENTS');
                var $rootScope = $injector.get('$rootScope');
                var $state = $injector.get('$state');
                var eventoConhecido = {
                    401: AUTH_EVENTS.notAuthenticated,
                    403: AUTH_EVENTS.notAuthorized,
                    404: AUTH_EVENTS.notFound,
                    419: AUTH_EVENTS.sessionTimeout,
                    500: AUTH_EVENTS.serverError
                }[response.status];
                if (eventoConhecido)
                    $rootScope.$broadcast(eventoConhecido, { state: $state.current, response: response });
                else
                    $rootScope.$broadcast(AUTH_EVENTS.otherError, { state: $state.current, response: response });
                return $q.reject(response);
            } 
        };
    }

})();