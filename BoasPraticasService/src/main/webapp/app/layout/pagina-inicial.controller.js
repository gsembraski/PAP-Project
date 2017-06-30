(function () {
    'use strict';

    angular
        .module('app.layout')
        .controller('PaginaInicialController', PaginaInicialController);

    PaginaInicialController.$inject = ['$window', '$uibModal', 'seguranca', 'usuarioServices'];

    function PaginaInicialController($window, $uibModal, seguranca, usuarioServices) {
        /* jshint validthis:true */
        var vm = this;
        
        vm.item = {};
        vm.storage = $window.localStorage;
        
        vm.autenticado = autenticado;
        vm.buscarItem = buscarItem;
		vm.abrirModalCadastrar = abrirModalCadastrar;
		vm.abrirModalEditar = abrirModalEditar;
		vm.abrirModalLogin = abrirModalLogin;
		vm.excluirConta = excluirConta;

        function autenticado() {
            return seguranca.authenticated;
        }
        
		function buscarItem(){
	        vm.user = angular.fromJson(vm.storage.getItem('security'));
			if(vm.user)
				usuarioServices.buscarItem(vm.user.login).then(function(response){
					vm.item = response.data;
	
					if(!vm.item)
			            seguranca.logout();					
				});
		}
		
		function abrirModalCadastrar(){
			$uibModal.open({
			      templateUrl: 'app/usuario/modal/modal-usuario.html',
			      size: 'md',
			      controller: 'UsuarioCadastrarController',
			      controllerAs: 'vm',
			      backdrop: 'static'
				});
		}
		
		function abrirModalEditar(){
			var modalInstance = $uibModal.open({
					    templateUrl: 'app/usuario/modal/modal-usuario.html',
					    size: 'md',
					    controller: 'UsuarioEditarController',
					    controllerAs: 'vm',
					    backdrop: 'static',
					    resolve: {
					    	params:{email: vm.user.login}
					    }
					});
		}
		
		function abrirModalLogin(operacao){
			var modalInstance = $uibModal.open({
			      templateUrl: 'app/usuario/modal/modal-usuario-login.html',
			      size: 'smx',
			      controller: 'UsuarioLoginController',
			      controllerAs: 'vm',
			      backdrop: 'static'
			    });

		    modalInstance.result.then(function (selectedItem) {
		    	buscarItem();
		    });
		}
		
		function excluirConta(){
	        vm.user = angular.fromJson(vm.storage.getItem('security'));
			if(vm.user)
				usuarioServices.deletar(vm.user.login).then(function(response){
					toastr.success("Conta excluída com sucesso.");				
				}).finally(function () {
					seguranca.logout();
	            });
		}
		
		activate();
		
		function activate(){
			buscarItem();
		}
    }
})();
