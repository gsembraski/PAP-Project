(function () {
    'use strict';

    angular
        .module('app.usuario')
        .controller('UsuarioEditarController', UsuarioEditarController);

    UsuarioEditarController.$inject = ['params', '$uibModalInstance', 'usuarioServices'];
    /* @ngInject */
    function UsuarioEditarController(params, $uibModalInstance, usuarioServices) {
		var vm = this;	

		vm.email = params.email;
		vm.item = {};
		vm.confirmacaoSenha = '';
		vm.busy = false;
		vm.ediao = true;
		vm.senha = "";
		
		vm.cancelar = cancelar;
		vm.diretivasInformadas = diretivasInformadas;
		vm.getOperacao = getOperacao;
		vm.setNgClassEmail = setNgClassEmail;
		vm.minSenha = minSenha;
		vm.minSenhaAntiga = minSenhaAntiga;
		vm.minConfirmaSenha = minConfirmaSenha;
		vm.salvar = salvar;
		vm.temSenha = temSenha;
		vm.verificaSenha = verificaSenha;
		vm.verificaSenhaAntiga = verificaSenhaAntiga;
		
		function buscarItem(){
			usuarioServices.buscarItem(vm.email).then(function(response){
				vm.item = response.data;
				vm.senha = angular.copy(vm.item.senha);
				vm.item.senha = "";
			});
		}
		
		function cancelar(){
			$uibModalInstance.dismiss();
		}
		
		function getOperacao(){
			if(vm.ediao)
				return "Editar";
			return "Cadastrar";
		}
		
		function salvar(form){
			if(form.$valid && diretivasInformadas()){
				usuarioServices.atualizar(vm.item).then(function(response){
					if(response){
	                    toastr.success('Usuário atualizado com sucesso!');
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
			return vm.verificaSenha() && !vm.minSenha() && !vm.minConfirmaSenha();
		}
		
		function setNgClassEmail(form){
			if(form.$submitted && (form.inputSenhaAntiga.$invalid || vm.minSenhaAntiga() || (!vm.verificaSenhaAntiga() && vm.senhaAntiga)))
				return 'has-error';
			else if(verificaSenhaAntiga() && vm.senhaAntiga)
				return 'has-feedback';
			else
				return '';
		}
				
		function temSenha(){
			return vm.item.senha && vm.confirmacaoSenha;
		}
		
		function verificaSenha(){
			return vm.item && angular.equals(vm.item.senha, vm.confirmacaoSenha);
		}
		
		function verificaSenhaAntiga(){
			return angular.equals(vm.senhaAntiga, vm.senha);
		}
		
		function minSenhaAntiga(){
			return vm.senhaAntiga && vm.senhaAntiga.length < 6;
		}
		
		function minSenha(){
			return vm.item && vm.item.senha && vm.item.senha.length < 6;
		}
		
		function minConfirmaSenha(){
			return vm.confirmacaoSenha && vm.confirmacaoSenha.length < 6;
		}
		
		activate();
		
		function activate(){
			buscarItem();
		}
    }
})();