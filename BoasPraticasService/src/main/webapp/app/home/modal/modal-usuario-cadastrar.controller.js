(function () {
    'use strict';

    angular
        .module('app.home')
        .controller('UsuarioCadastrarController', UsuarioCadastrarController);

    UsuarioCadastrarController.$inject = ['params', '$uibModalInstance', 'homeServices'];
    /* @ngInject */
    function UsuarioCadastrarController(params, $uibModalInstance, homeServices) {
		var vm = this;	
		
		vm.item = {};
		vm.confirmacaoSenha = '';
		vm.operacao = params.operacao;
		vm.temEmailCadastrado = false;
		
		vm.cancelar = cancelar;
		vm.diretivasInformadas = diretivasInformadas;
		vm.minSenha = minSenha;
		vm.minConfirmaSenha = minConfirmaSenha;
		vm.salvar = salvar;
		vm.setNgClassEmail = setNgClassEmail;
		vm.temSenha = temSenha;
		vm.validarEmail = validarEmail;
		vm.verificaSenha = verificaSenha;
		
		function cancelar(){
			$uibModalInstance.dismiss();
		}
		
		function salvar(form){
			if(form.$valid && diretivasInformadas()){
				homeServices.cadastrar(vm.item).then(function(response){
					if(response){
						vm.mensagem = 'Login cadastrado com sucesso!';
	                    toastr.success('Usuário cadastrado com sucesso!');
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
		
		function diretivasInformadas(){
			return vm.verificaSenha() && !vm.temEmailCadastrado && !vm.minSenha() && !vm.minConfirmaSenha()
		}
				
		function temSenha(){
			return vm.item.senha && vm.confirmacaoSenha;
		}
		
		function verificaSenha(){
			return vm.item && angular.equals(vm.item.senha, vm.confirmacaoSenha);
		}
		
		function validarEmail(form){
			if(form.inputEmail.$valid && vm.item.email)
				homeServices.existeEmail(vm.item.email).then(function(response){
					vm.temEmailCadastrado = response.data;
				});
		}
		
		function minSenha(){
			return vm.item && vm.item.senha && vm.item.senha.length < 6;
		}
		
		function minConfirmaSenha(){
			return vm.confirmacaoSenha && vm.confirmacaoSenha.length < 6;
		}
		
		function setNgClassEmail(form){
			if((form.$submitted && (form.inputEmail.$invalid || !vm.item.email)) || vm.temEmailCadastrado && vm.item.email)
				return 'has-error';
			else if(!vm.temEmailCadastrado && vm.item.email)
				return 'has-feedback';
			else
				return '';
		}
    }
})();