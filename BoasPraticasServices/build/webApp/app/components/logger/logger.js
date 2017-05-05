(function () {
    'use strict';

    angular
        .module('blocks.logger')
        .factory('logger', logger);

    logger.$inject = ['$log', 'toastr'];

    /* @ngInject */
    function logger($log, toastr) {
        var service = {
            showToasts: true,

            error: error,
            info: info,
            success: success,
            warning: warning,

            // straight to console; bypass toastr
            log: $log.log
        };

        return service;
        /////////////////////

        function error(message, data, title) {
            toastr.error('A seguinte mensagem foi retornada pelo sistema: ' + message, "Erro");
            $log.error('Error: AgendaNet: ' + message, data);
        }

        function info(message, data, title) {
            //toastr.info(message, title);
            $log.info('Info: AgendaNet: ' + message, data);
        }

        function success(message, data, title) {
            //toastr.success(message, title);
            $log.success('Success: AgendaNet: ' + message, data);
        }

        function warning(message, data, title) {
            //toastr.warning(message, title);
            $log.warn('Warning: AgendaNet: ' + message, data);
        }
    }
}());
