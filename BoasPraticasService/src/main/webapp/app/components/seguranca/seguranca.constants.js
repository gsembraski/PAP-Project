(function () {
    'use strict';

    angular
        .module('app.seguranca')        .
        constant('nivelAcesso', { SELECIONAR: 1, INSERIR: 2, MODIFICAR: 4, EXCLUIR: 8 })
        .constant('recursos', {
            mbp: 'mbp'
        })
        .constant('AUTH_EVENTS', {
            loginSuccess: 'auth-login-success',
            loginFailed: 'auth-login-failed',
            logoutSuccess: 'auth-logout-success',
            sessionTimeout: 'auth-session-timeout',
            notAuthenticated: 'auth-not-authenticated',
            notAuthorized: 'auth-not-authorized',
            notFound: 'auth-not-found',
            serverError: 'auth-internal-server-error',
            otherError: 'auth-response-error'
        });
})();
