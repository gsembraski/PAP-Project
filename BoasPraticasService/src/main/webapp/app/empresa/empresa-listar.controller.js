(function(){
	'use-strict';
	
	angular
		.module('app.empresa')
		.controller('EmpresaListarController', EmpresaListarController);
	
	EmpresaListarController.$inject = ['$state', '$window', 'empresaService'];
    /* @ngInject */
    function EmpresaListarController($state, $window, empresaService) {
    	var vm = this;
    	
    	vm.cnpj = '';
    	vm.item = {};
    	vm.listaEmpresas = [];
        vm.storage = $window.localStorage;
    	
    	vm.buscar = buscar;
    	vm.cadastrar = cadastrar;
    	vm.editar = editar;
    	vm.excluir = excluir;
    	vm.temItens = temItens;
    	vm.temItemSelecionado = temItemSelecionado;
    	vm.visualizar = visualizar;
    	
    	function buscar(){
    		empresaService.buscar(vm.usuario.login).then(function(response){
    			vm.listaEmpresas = response.data;
    		});
    	}
    	
    	function cadastrar(){
			$state.go('^.cadastrar');
    	}
    	
    	function editar(id){
			$state.go('^.editar', { id: id });
    	}
    	
    	function excluir(id){
    		empresaService.deletar(id).then(function(){
    			buscar();
    			toastr.success('Empresa excluida com sucesso!');
    		});
    	}
    	
    	function getUsuario(){
            vm.usuario = angular.fromJson(vm.storage.getItem('security'));
    	}
    	
    	function temItens(){
    		return vm.listaEmpresas && vm.listaEmpresas.length;
    	}
    	
    	function temItemSelecionado(){
    		return vm.item && vm.item.id;
    	}
		
		function visualizar(item){
			vm.cnpj = item.cnpj.replace(/(\d{2})(\d{3})(\d{3})(\d{4})(\d{2})/g,"\$1.\$2.\$3\/\$4\-\$5");
			vm.item = item;
		}
		
		activate();
		
		function activate(){
			getUsuario();
			buscar();
		}
    }
	
})();