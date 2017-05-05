(function () {
    'use strict';

    angular
        .module('app.manual')
        .controller('ManualCadastrarController', ManualCadastrarController);
	
    ManualCadastrarController.$inject = ['$state', 'manualServices', 'empresaService'];
	function ManualCadastrarController($state, manualServices, empresaService){
		var vm = this;
		
		vm.empresa = {};
		vm.empresaId = '';
		vm.item = {};		
		vm.item.respostaList = [];
		vm.listaEmpresas = [];
		vm.operacao = 'Cadastrar';
		
		//collapsed
		vm.isCollapsed1 = true;
		vm.isCollapsed2 = true;
		vm.isCollapsed3 = true;
		vm.isCollapsed4 = true;
		vm.isCollapsed41 = true;
		vm.isCollapsed42 = true;
		vm.isCollapsed421 = true;
		vm.isCollapsed422 = true;
		vm.isCollapsed423 = true;
		vm.isCollapsed424 = true;
		vm.isCollapsed425 = true;		
		vm.isCollapsed426 = true;
		vm.isCollapsed427 = true;
		vm.isCollapsed428 = true;
		vm.isCollapsed429 = true;
		vm.isCollapsed4210 = true;
		vm.isCollapsed4211 = true;
		vm.isCollapsed4212 = true;
		vm.isCollapsed4213 = true;
		vm.isCollapsed45 = true;
		vm.isCollapsed46 = true;
		vm.isCollapsed47 = true;
		vm.isCollapsed471 = true
		vm.isCollapsed472 = true
		vm.isCollapsed473 = true
		vm.isCollapsed48 = true;
		vm.isCollapsed481 = true
		vm.isCollapsed482 = true
		vm.isCollapsed49 = true;
		vm.isCollapsed410 = true;
		vm.isCollapsed411 = true;
		vm.isCollapsed412 = true;
		vm.isCollapsed413 = true;
		vm.isCollapsed414 = true;
		vm.isCollapsed415 = true;
		vm.isCollapsed416 = true;
		vm.isCollapsed417 = true;
		vm.isCollapsed418 = true;
		
		vm.salvar = salvar;
		vm.cancelar = cancelar;
		vm.podeVisualizar = podeVisualizar;
		vm.setEmpresa = setEmpresa;
		vm.setTooltip = setTooltip;
		
		activate();
		
		function activate(){
			inicieManual();
		}
		
		function inicieManual(){				
			for(var i = 0; i <= 88; i++){
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
			if(form.$valid)				
				manualServices.cadastrar(vm.item).then(function(response){
					toastr.success('Manual salvo com sucesso!');
					$state.go('^.listar');						
				});
		}
		
		function setEmpresa(){
			if(vm.empresa){
				vm.item.revisao = 1;
				vm.item.empresaID = vm.empresa.id;
				vm.item.respostaList[4].texto = vm.empresa.razaoSocial;
				vm.item.respostaList[5].texto = vm.empresa.nomeFantasia;
				vm.item.respostaList[8].texto = vm.empresa.cnpj;
			}
		}	
		
		function setTooltip(expande){
			if(expande)
				return 'Expandir';
			return 'Esconder';
		}
		
		function cancelar (){
			$state.go('^.listar');
		}
	}
})();