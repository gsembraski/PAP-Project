; (function () {
    'use strict';

    angular
        .module('app.empresa')
        .controller('EmpresaSelecaoController', EmpresaSelecaoController);

    EmpresaSelecaoController.$inject = ['$scope', '$window', 'empresaService'];
    function EmpresaSelecaoController($scope, $window, empresaService) {
        /* jshint validthis:true */
        var vm = this;

        vm.itemSelecionado = vm.itemSelecionado || null;
        vm.listaItens = [];
        vm.storage = $window.localStorage;
		vm.usuario = angular.fromJson(vm.storage.getItem('security'));

        vm.buscar = buscar;
        vm.changed = changed;
        vm.buscarInicial = buscarInicial;

        activate();

        function activate() {
            buscar();
        }

        function buscar() {
        	empresaService.buscar(vm.usuario.login).then(function (response) {
                vm.listaItens = response.data;
            });
        }

        function changed() {
            if (vm.itemSelecionado)
                $scope.updateValue(vm.itemSelecionado.id);
            else
                $scope.updateValue(undefined);
        }

        function buscarInicial(id) {
            if (!id) {
                vm.itemSelecionado = null;
                return;
            }
            if (vm.itemSelecionado && id === vm.itemSelecionado.id)
                return;

            empresaService.buscarItem(id).then(function (response) {
                vm.itemSelecionado = response.data;
            });
        }
    }

})();
