(function () {
    'use strict';

    angular
        .module('app.manual')
        .controller('ManualListarController', ManualListarController);
	
	function ManualListarController($state){
		var vm = this;
		
		vm.manual = undefined;
		vm.listaManual = [];
		
		//teste
		vm.teste = {};
		vm.teste2 = {};
		vm.teste.razaoSocial = 'Green Power LTDA';
		vm.listaManual.push(vm.teste);		
		vm.teste2.razaoSocial = 'Larica Master LTDA';
		vm.listaManual.push(vm.teste2);
		
		vm.cadastrar = cadastrar;
		vm.SetManualVisualizar = SetManualVisualizar;
		vm.temManual = temManual;
		vm.temManualSelecionado = temManualSelecionado;
		
		function cadastrar(){
			$state.go('^.cadastrar')
		}
		
		function SetManualVisualizar(item){
			vm.manual = item;
		}
		
		function temManual() {
			return vm.listaManual && vm.listaManual.length;
		}
		
		function temManualSelecionado(){
			return vm.manual;
		}
	}
})();