appHome.controller('UsuarioLoginController', function ($window, $uibModalInstance, homeServices){
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
			vm.item.ultimoAcesso = new Date();
			homeServices.logar(vm.item).then(function(response){
				if(response.data && response.data.id){   
					upStorage(response.data);
					$uibModalInstance.close();
				}
			}, function(response){
				toastr.error('Verifique se o usuário e senha foram digitados corretamente');
			});
		}
	}
	
	function upStorage(usuario){
		var item = {};
		item.usuario = usuario.email;
		item.guid = usuario.senha;
		item.data = usuario.ultimoAcesso;
		vm.storage.setItem('security', angular.toJson(item));
        vm.local = vm.storage.getItem('security');
	}
});