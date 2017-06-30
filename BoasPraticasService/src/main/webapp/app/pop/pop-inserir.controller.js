(function () {
    'use strict';

    angular
        .module('app.pop')
        .controller('PopCadastrarController', PopCadastrarController);

    PopCadastrarController.$inject = ['$state', 'popServices'];
	function PopCadastrarController($state, popServices){
		var vm = this;

		vm.popDescricao = '';
		vm.popNum = parseInt($state.params.popNum);
		vm.item = {};
		vm.item.respostaList = [];
		vm.operacao = 'Cadastrar';
		vm.busy = false;
		
		//collapsed
		vm.isCollapsed1 = true;
		vm.isCollapsed2 = true;
		vm.isCollapsed21 = true;
		vm.isCollapsed22 = true;
		vm.isCollapsed23 = true;
		vm.isCollapsed3 = true;
		vm.isCollapsed4 = true;
		vm.isCollapsed5 = true;
		vm.isCollapsed6 = true;
		vm.isCollapsed7 = true;
		
		vm.iniciePop = iniciePop
		vm.salvar = salvar;
		vm.cancelar = cancelar;
		vm.podeVisualizar = podeVisualizar;
		vm.setTooltip = setTooltip;
		vm.verificaNumPopValido = verificaNumPopValido;
		
		function iniciePop(){	
			vm.item.revisao = 1;
			vm.item.empresaID = vm.empresa.id;	
			vm.item.numPop = vm.popNum;
			
			if(vm.popNum == 1)
				for(var i = 0; i <= 13; i++){
					var resposta = {};
					resposta.texto = '';
					resposta.numeroResposta = i + 1;
					vm.item.respostaList.push(resposta);
				}
			else if(vm.popNum == 2)
				for(var i = 0; i <= 9; i++){
					var resposta = {};
					resposta.texto = '';
					resposta.numeroResposta = i + 1;
					vm.item.respostaList.push(resposta);
				}
			else if(vm.popNum == 3)
				for(var i = 0; i <= 8; i++){
					var resposta = {};
					resposta.texto = '';
					resposta.numeroResposta = i + 1;
					vm.item.respostaList.push(resposta);
				}
			else if(vm.popNum == 4)
				for(var i = 0; i <= 12; i++){
					var resposta = {};
					resposta.texto = '';
					resposta.numeroResposta = i + 1;
					vm.item.respostaList.push(resposta);
				}
		}
		
		function podeVisualizar(){
			return (vm.empresaId && vm.operacao === 'Cadastrar') || vm.operacao === 'Editar';
		}
		
		function salvar(form){
			if(!vm.empresa){
				SetPopDescricao();
				toastr.warning('Para salvar o pop de ' + vm.popDescricao + 'selecione uma empresa.');
				return;
			}
			
			if(form.$valid){				
	            if (vm.busy)
	                return;

	            vm.busy = true;
				popServices.cadastrar(vm.item).then(function(response){
					toastr.success('POP - ' + vm.popDescricao + ' salvo com sucesso!');
					$state.go('^.listar', {popNum: vm.popNum});						
				}).finally(function () {
	                vm.busy = false;
	            });
			}
		}
		
		function SetPopDescricao(){
			if(vm.popNum == 1)
				vm.popDescricao = 'Higienização de Instalações, Equipamentos e Móveis';
			else if(vm.popNum == 2)
				vm.popDescricao = 'Controle Integrado de Vetores e Pragas Urbanas';
			else if(vm.popNum == 3)
				vm.popDescricao = 'Higienização do Reservatório de Água';
			else if(vm.popNum == 4)
				vm.popDescricao = 'Higiene e à Saúde dos Manipuladores';
		}
		
		function setTooltip(expande){
			if(expande)
				return 'Expandir';
			return 'Esconder';
		}
		
		function cancelar (){
			$state.go('^.listar', {popNum: vm.popNum});
		}
		
		function verificaNumPopValido(){
			return vm.popNum > 0 && vm.popNum < 5;
		}
		
		activate();
		
		function activate(){
			SetPopDescricao();
		}
	}
})();