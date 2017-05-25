(function () {
    'use strict';

    angular
        .module('app.pop')
        .controller('PopEditarController', PopEditarController);

    PopEditarController.$inject = ['$state', 'popServices'];
	function PopEditarController($state, popServices){
		var vm = this;

		vm.popDescricao = '';
		vm.id = $state.params.id;
		vm.item = {};
		vm.operacao = 'Editar';
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
		
		vm.salvar = salvar;
		vm.cancelar = cancelar;
		vm.podeVisualizar = podeVisualizar;
		vm.setTooltip = setTooltip;
		vm.verificaNumPopValido = verificaNumPopValido;
		
		function buscarItem(){
			popServices.buscarItem(vm.id).then(function(response){
				vm.item = response.data;
				vm.popNum = vm.item.numPop;
				SetPopDescricao();
			});
		}
		
		function podeVisualizar(){
			return (vm.empresaId && vm.operacao === 'Cadastrar') || vm.operacao === 'Editar';
		}
		
		function salvar(form){
			if(form.$valid){		
	            if (vm.busy)
	                return;

	            vm.busy = true;			
				popServices.atualizar(vm.item).then(function(response){
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
				vm.popDescricao = 'Higienização do Reservatório de água';
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
			buscarItem();
		}
	}
})();