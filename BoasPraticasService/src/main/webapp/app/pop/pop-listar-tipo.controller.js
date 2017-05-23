(function () {
    'use strict';

    angular
        .module('app.pop')
        .controller('PopListarTipoController', PopListarTipoController);

    PopListarTipoController.$inject = ['$state'];
	function PopListarTipoController($state){
		var vm = this;
		
		vm.popNum = '';

		vm.listaPop = listaPop;
    	
    	function listaPop(popNum){
			$state.go('^.listar', { popNum: popNum });
    	}
	}
})();