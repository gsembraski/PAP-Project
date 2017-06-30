(function(){
	'use strict';
	
	angular
		.module('app.empresa')
		.controller('EmpresaCadastrarController', EmpresaCadastrarController);
	
	EmpresaCadastrarController.$inject = ['$state', '$window', 'empresaService'];
	function EmpresaCadastrarController($state, $window, empresaService){
		var vm = this;
		
		vm.id = $state.params.id;
		vm.item = {};
        vm.storage = $window.localStorage;
		vm.operacao = 'Cadastrar';
		vm.busy = false;
		
		vm.cancelar = cancelar;
		vm.diretivasInformadas = diretivasInformadas;
		vm.salvar = salvar;
    	
    	function cancelar(){
			$state.go('^.listar');
    	}
    	
    	function diretivasInformadas(){
    		return true;
    	}
    	
    	function getUsuario(){
            vm.usuario = angular.fromJson(vm.storage.getItem('security'));
    	}
		
		function salvar(form){
			if(form.$valid && vm.usuario){
	            if (vm.busy)
	                return;

	            vm.busy = true;
				vm.item.usuarioEmail = vm.usuario.login;
				empresaService.cadastrar(vm.item).then(function(response){
					if(response.data.statusCodeValue == 404 || response.data.statusCodeValue == 500){
						toastr.error("CNPJ inválido!");
						return;
					}
					
					$state.go('^.listar');
					toastr.success(response.data.body);
				}).finally(function () {
	                vm.busy = false;
	            });
			}
		}
		
		activate();
		
		function activate(){
			getUsuario();
		}
				
	}
})();