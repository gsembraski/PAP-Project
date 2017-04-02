(function () {
    'use strict';

    angular
        .module('app.home')
        .controller('HomeController', HomeController);

	function HomeController ($uibModal){
		var vm = this;
		
		vm.abrirModalCadastrar = abrirModalCadastrar;
		vm.abrirModalLogin = abrirModalLogin;
		
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
            modalInstance.result.then(function () {
                vm.autenticado = true;
            });
		}
	};
})();