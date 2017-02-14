appHome.controller('UsuarioLoginController', function ($uibModalInstance, homeServices){
	var vm = this;
		
	vm.item = {};
	
	vm.cancelar = cancelar;
	vm.entrar = entrar;
	
	function cancelar(){
		$uibModalInstance.dismiss();
	}
	
	function entrar(form){
		if(form.$valid){
			vm.item.ultimoAcesso = new Date();
			homeServices.logar(vm.item).then(function(response){
				toastr.success('Login realizado com sucesso!');
				$uibModalInstance.close();
			}, function(response){
				toastr.error('Verifique se o usuário e senha foram digitados corretamente');
			});
		}
	}
});