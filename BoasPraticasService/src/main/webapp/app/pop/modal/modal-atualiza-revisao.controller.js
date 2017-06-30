(function () {
    'use strict';

    angular
        .module('app.pop')
        .controller('PopAtualizaRevisaoController', PopAtualizaRevisaoController);

    PopAtualizaRevisaoController.$inject = ['$uibModalInstance'];
    /* @ngInject */
    function PopAtualizaRevisaoController($uibModalInstance) {
	        		
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