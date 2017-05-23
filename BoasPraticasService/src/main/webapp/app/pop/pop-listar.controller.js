(function () {
    'use strict';

    angular
        .module('app.pop')
        .controller('PopListarController', PopListarController);

    PopListarController.$inject = ['$state', '$window', 'popServices'];
	function PopListarController($state, $window, popServices){
		var vm = this;
		
		vm.popDescricao = '';
		vm.popNum = $state.params.popNum;
		vm.pop = undefined;
		vm.listaPop = [];
        vm.storage = $window.localStorage;

		vm.buscar = buscar;
		vm.cadastrar = cadastrar;
    	vm.editar = editar;
    	vm.excluir = excluir;
    	vm.selecaoPop = selecaoPop;
		vm.SetPopVisualizar = SetPopVisualizar;
		vm.temPop = temPop;
		vm.temPopSelecionado = temPopSelecionado;
		vm.verificaNumPopValido = verificaNumPopValido;
		
		function buscar(){
			vm.usuario = angular.fromJson(vm.storage.getItem('security'));
			if(vm.usuario && verificaNumPopValido())
				popServices.buscar(vm.popNum, vm.usuario.login).then(function(response){
	    			vm.listaPop = response.data;
	    		});
		}
		
		function selecaoPop(){
			$state.go('^.listaTipo')
		}
		
		function cadastrar(){
			$state.go('^.cadastrar', { popNum: vm.popNum })
		}
    	
    	function editar(id){
			$state.go('^.editar', { id: id });
    	}
    	
    	function excluir(id){
    		popServices.deletar(id).then(function(){
    			buscar();
    			toastr.success('POP - '+  vm.popDescricao +' excluida com sucesso!');
    		});
    	}
		
		function SetPopDescricao(){
			if(vm.popNum == 1)
				vm.popDescricao = 'Higienização de Instalações, Equipamentos e Móveis';
			else if(vm.popNum == 2)
				vm.popDescricao = 'Controle Integrado de Vetores e Pragas Urbanas';
			else if(vm.popNum == 3)
				vm.popDescricao = 'Higienização do Reservatório de água';
			else if(vm.popNum == 4)
				vm.popDescricao = 'Higiene e à Saúde dos Manipuladores';
		}
		
		function SetPopVisualizar(item){
			vm.pop = item;
		}
		
		function temPop() {
			return vm.listaPop && vm.listaPop.length;
		}
		
		function temPopSelecionado(){
			return vm.pop;
		}
		
		function verificaNumPopValido(){
			return vm.popNum > 0 && vm.popNum < 5;
		}
		
		activate();
		
		function activate(){
			SetPopDescricao();
			buscar();
		}
	}
})();