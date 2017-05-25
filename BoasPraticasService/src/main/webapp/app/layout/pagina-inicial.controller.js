(function () {
    'use strict';

    angular
        .module('app.layout')
        .controller('PaginaInicialController', PaginaInicialController);

    PaginaInicialController.$inject = ['$uibModal', 'seguranca'];

    function PaginaInicialController($uibModal, seguranca) {
        /* jshint validthis:true */
        var vm = this;
        vm.autenticado = autenticado;
		vm.abrirModalCadastrar = abrirModalCadastrar;
		vm.abrirModalLogin = abrirModalLogin;

        function autenticado() {
            return seguranca.authenticated;
        }
		
		function abrirModalCadastrar(operacao){
			$uibModal.open({
			      templateUrl: 'app/home/modal/modal-usuario.html',
			      size: 'md',
			      controller: 'UsuarioCadastrarController',
			      controllerAs: 'vm',
			      backdrop: 'static',
			      resolve: {
			    	  params:{operacao: operacao}
			      }
				});
		}
		
		function abrirModalLogin(operacao){
			var modalInstance = $uibModal.open({
			      templateUrl: 'app/home/modal/modal-usuario-login.html',
			      size: 'smx',
			      controller: 'UsuarioLoginController',
			      controllerAs: 'vm',
			      backdrop: 'static'
			    });
		}
    }
})();
