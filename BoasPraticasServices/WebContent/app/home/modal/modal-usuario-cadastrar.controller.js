appHome.controller('UsuarioCadastrarController', function ($uibModalInstance, params, homeServices){
	var vm = this;	
	
	vm.item = {};
	vm.confirmacaoSenha = '';
	vm.operacao = params.operacao;
	
	vm.cancelar = cancelar;
	vm.salvar = salvar;
	vm.temSenha = temSenha;
	vm.verificaSenha = verificaSenha;
	
	function cancelar(){
		$uibModalInstance.dismiss();
	}
	
	function salvar(form){
		if(form.$valid && verificaSenha()){
			homeServices.cadastrar(vm.item).then(function(response){
				if(response){
					vm.mensagem = 'Login cadastrado com sucesso!';
					vm.success = true;
					vm.hasError = false;
					
					$uibModalInstance.close();
				}else{
					vm.mensagem = 'Não foi possivel realizar o cadastro!';
					vm.hasError = true;
					vm.success = false;
				}
			});
		}
	}
	
	function temSenha(){
		return vm.item.senha && vm.confirmacaoSenha;
	}
	
	function verificaSenha(){
		return vm.item && angular.equals(vm.item.senha, vm.confirmacaoSenha);
	}
});