(function () {
    'use strict';

    angular
        .module('app.usuario')
        .controller('UsuarioLoginController', UsuarioLoginController);

    UsuarioLoginController.$inject = ['$window', '$uibModalInstance', 'usuarioServices'];
    /* @ngInject */
    function UsuarioLoginController($window, $uibModalInstance, usuarioServices) {
        		
	var vm = this;
		
	vm.item = {};
	
	vm.cancelar = cancelar;
	vm.entrar = entrar;
    vm.storage = $window.localStorage;
	
	function cancelar(){
		$uibModalInstance.dismiss();
	}
	
	function entrar(form){
		if(form.$valid){
			usuarioServices.logar(vm.item).then(function(response){
				if(response.data.statusCodeValue == 404 || response.data.statusCodeValue == 500){
					toastr.error('Verifique se o usuário e senha foram digitados corretamente');
					return;
				}
					
				upStorage(response.data.body);
				toastr.success('Login realizado com sucesso!');
				$uibModalInstance.close();
			});
		}
	}
	
	function upStorage(usuario){
		var item = {};
		item.login = usuario.email;
		item.guid = usuario.senha;
		item.data = usuario.ultimoAcesso;
		item.id = usuario.id;
		vm.storage.setItem('security', angular.toJson(item));
        vm.local = vm.storage.getItem('security');
	}
        }
})();