(function () {
    'use strict';

    angular
        .module('blocks.toastInterceptor')
        .factory('toastAuthEventsInterceptor', toastAuthEventsInterceptor);

    toastAuthEventsInterceptor.$inject = ['$rootScope', '$state', 'AUTH_EVENTS'];

    function toastAuthEventsInterceptor($rootScope, $state, AUTH_EVENTS) {

        return {
            iniciarService: iniciarService
        };

        function iniciarService() {
            $rootScope.$on(AUTH_EVENTS.loginSuccess, loginSuccess);
            $rootScope.$on(AUTH_EVENTS.logoutSuccess, logoutSuccess);
            $rootScope.$on(AUTH_EVENTS.notAuthorized, notAuthorized);
            $rootScope.$on(AUTH_EVENTS.notAuthenticated, notAuthenticated);
            $rootScope.$on(AUTH_EVENTS.serverError, serverError);
            $rootScope.$on(AUTH_EVENTS.otherError, otherError);
        }

        function loginSuccess() {
            toastr.info('Login realizado com sucesso.', 'Login');
        }

        function logoutSuccess() {
            toastr.info('Logout realizado com sucesso.', 'Logout');
        }

        function notAuthorized() {
            toastr.warning('Você não tem permissão para acessar este recurso.', 'Segurança');
        }

        function notAuthenticated() {
            toastr.warning('Você precisa estar autenticado para acessar este recurso.', 'Segurança');
        }

        function serverError(event, args) {
            toastr.error(extractMessage(args.response) || 'Ocorreu um erro ao processar a requisição no servidor.', 'Erro');
        }

        function otherError(event, args) {
            toastr.error(extractMessage(args.response) || 'Ocorreu um erro de comunicação com o servidor.', 'Erro');
        }

        function extractMessage(rejection) {
            if (angular.isObject(rejection.data))
                return rejection.data.ExceptionMessage || rejection.data.Message || rejection.data.message;
            return null;
        }

    }

})();