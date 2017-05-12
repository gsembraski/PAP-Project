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
			if(form.$valid && diretivasInformadas()){
				vm.item.usuarioID = vm.usuario.id;
				empresaService.cadastrar(vm.item).then(function(response){
					$state.go('^.listar');
					toastr.success('Empresa cadastrada com sucesso!');
				});
			}
		}
		
		activate();
		
		function activate(){
			getUsuario();
		}
				
	}
})();