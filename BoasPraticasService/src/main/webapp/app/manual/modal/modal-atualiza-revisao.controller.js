(function () {
    'use strict';

    angular
        .module('app.manual')
        .controller('ManualAtualizaRevisaoController', ManualAtualizaRevisaoController);

    ManualAtualizaRevisaoController.$inject = ['$uibModalInstance'];
    /* @ngInject */
    function ManualAtualizaRevisaoController($uibModalInstance) {
	        		
		var vm = this;
			
		vm.cancelar = cancelar;
		vm.atualizar = atualizar;
		
		function cancelar(){
			$uibModalInstance.dismiss();
		}
		
		function atualizar(){
			$uibModalInstance.close();
		}
    }
})();