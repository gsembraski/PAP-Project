(function (){
	appManual.controller('ManualCadastrarController', ManualCadastrarController);
	
	function ManualCadastrarController($state, manualServices){
		var vm = this;
		
		vm.item = {};
		
		vm.salvar = salvar;
		vm.cancelar = cancelar;
		
		activate();
		
		function activate(){
			inicieManual();
		}
		
		function inicieManual(){
			
			vm.item.revisao = 1;
			vm.item.resp = [];
			
			for(var i = 0; i <= 89; i++){
				var resposta = {};
				
				resposta.resposta = '';
				resposta.num_pergunta = i + 1;
				
				vm.item.resp.push(resposta);
			}
		}
		
		function salvar(form){
			if(form.$valid)
				vm.item.razaosocial = vm.item.resp[5].resposta;
					manualServices.cadastrar(vm.item).then(function(response){
						toastr.success('Login realizado com sucesso!');
						if(response){
							vm.mensagem = 'Manual salvo com sucesso!';
							vm.success = true;
							vm.hasError = false;
							$state.go('manual.listar');
						}else{
							vm.mensagem = 'Não foi possivel salvar o manual!';
							vm.hasError = true;
							vm.success = false;
						}
					});
		}
		
		function cancelar (){
			$state.go('manual.listar');
		}
	}
})();