(function () {
    'use strict';

    angular
        .module('app.manual')
        .controller('ManualListarController', ManualListarController);
	
	function ManualListarController($state, $window, manualServices){
		var vm = this;
		
		vm.manual = undefined;
		vm.listaManual = [];
        vm.storage = $window.localStorage;

		vm.buscar = buscar;
		vm.cadastrar = cadastrar;
    	vm.editar = editar;
    	vm.excluir = excluir;
		vm.SetManualVisualizar = SetManualVisualizar;
		vm.temManual = temManual;
		vm.temManualSelecionado = temManualSelecionado;
		
		function buscar(){
			vm.usuario = angular.fromJson(vm.storage.getItem('security'));
			if(vm.usuario)
				manualServices.buscar(vm.usuario.login).then(function(response){
	    			vm.listaManual = response.data;
	    		});
		}
		
		function cadastrar(){
			$state.go('^.cadastrar')
		}
    	
    	function editar(id){
			$state.go('^.editar', { id: id });
    	}
    	
    	function excluir(id){
    		manualServices.deletar(id).then(function(){
    			buscar();
    			toastr.success('Empresa excluida com sucesso!');
    		});
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
		
		activate();
		
		function activate(){
			buscar();
		}
	}
})();