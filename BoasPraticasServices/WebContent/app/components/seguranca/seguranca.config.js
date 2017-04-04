(function () {
    'use strict';

    angular
        .module('app.seguranca')
        .config(httpConfig)
        .run(initRoutes);

    httpConfig.$inject = ['$httpProvider'];
    /* @ngInject */
    function httpConfig($httpProvider) {
        $httpProvider.interceptors.push('segurancaHttpInterceptorService');
    }

    initRoutes.$inject = ['segurancaAuthEventsListener'];
    /* @ngInject */
    function initRoutes(segurancaAuthEventsListener) {
        segurancaAuthEventsListener.inicializar();
    }
})();