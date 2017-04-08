(function(){
	'use strict';
	
	angular
		.module('app.empresa')
		.controller('EmpresaEditarController', EmpresaEditarController);
	
	EmpresaEditarController.$inject = ['$state', 'empresaService'];
	function EmpresaEditarController($state, empresaService){
		var vm = this;
		
		vm.id = $state.params.id;
		vm.item = {};
		
		vm.buscarItem = buscarItem;
		vm.cancelar = cancelar;
		vm.diretivasInformadas = diretivasInformadas;
		vm.salvar = salvar;
		vm.temAlteracao = temAlteracao;
		
		function buscarItem(){
			empresaService.buscarItem(vm.id).then(function(response){
				vm.item = response.data;
				vm.empresaData = angular.copy(vm.item);
			});
		}
    	
    	function cancelar(){
			$state.go('^.listar');
    	}
    	
    	function diretivasInformadas(){
    		return true;
    	}
		
		function salvar(form){
			if(form.$valid && diretivasInformadas())
				empresaService.atualizar(vm.item).then(function(response){
					$state.go('^.listar');
					toastr.success('Empresa atualizada com sucesso!');
				});
		}
		
		function temAlteracao(){
			return angular.equals(vm.empresaData, vm.item)
		}
		
		activate();
		
		function activate(){
			buscarItem();
		}
		
	}
})();