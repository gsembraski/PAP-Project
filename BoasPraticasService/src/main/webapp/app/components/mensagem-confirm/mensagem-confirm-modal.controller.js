; (function () {
    'use strict';

    angular
        .module('app.mensagem-confirm')
        .controller('MensagemConfirmController', MensagemConfirmController);

    MensagemConfirmController.$inject = ['$uibModalInstance', 'mensagem'];
    function MensagemConfirmController($uibModalInstance, mensagem) {
        var vm = this;

        vm.mensagem = mensagem;
        vm.confirmar = confirmar;
        vm.cancelar = cancelar;

        function confirmar() {
            $uibModalInstance.close();
        }

        function cancelar() {
            $uibModalInstance.dismiss();
        }

    }

})();
