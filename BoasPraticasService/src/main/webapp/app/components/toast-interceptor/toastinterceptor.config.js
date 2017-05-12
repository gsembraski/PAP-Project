(function () {
    'use strict';

    angular
        .module('blocks.toastInterceptor')
        .run(config);

    config.$inject = ['toastAuthEventsInterceptor'];
    /* @ngInject */
    function config(toastAuthEventsInterceptor) {
        toastAuthEventsInterceptor.iniciarService();
    }
})();