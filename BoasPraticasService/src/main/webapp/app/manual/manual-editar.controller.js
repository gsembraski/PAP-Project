(function () {
    'use strict';

    angular
        .module('app.manual')
        .controller('ManualEditarController', ManualEditarController);

    ManualEditarController.$inject = ['$state', '$uibModal', 'manualServices'];
	function ManualEditarController($state, $uibModal, manualServices){
		var vm = this;

		vm.id = $state.params.id;
		vm.item = {};
		vm.operacao = 'Editar';
		vm.busy = false;
		
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
		vm.setTooltip = setTooltip;
		
		function buscarItem(){
			manualServices.buscarItem(vm.id).then(function(response){
				vm.item = response.data;
				vm.empresaData = angular.copy(vm.item);
			});
		}
		
		function editar(){
			if (vm.busy)
                return;

            vm.busy = true;
					
			manualServices.atualizar(vm.item).then(function(response){
				toastr.success('Manual salvo com sucesso!');
				$state.go('^.listar');						
			}).finally(function () {
                vm.busy = false;
            });
		}
		
		function podeVisualizar(){
			return (vm.empresaId && vm.operacao === 'Cadastrar') || vm.operacao === 'Editar';
		}
		
		function salvar(form){
			if(form.$valid)	{
				var modalInstance = $uibModal.open({
				      templateUrl: 'app/manual/modal/modal-atualiza-revisao.html',
				      controller: 'ManualAtualizaRevisaoController',
				      controllerAs: 'vm',
				      backdrop: 'static'
				    });

			    modalInstance.result.then(function (selectedItem) {
			    	vm.item.revisao++;
			    	editar();
			    }, function () {
			    	editar();
			    });
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
		
		activate();
		
		function activate(){
			buscarItem();
		}
	}
})();