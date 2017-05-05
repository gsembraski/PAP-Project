(function () {
    'use strict';

    angular
        .module('app.empresa')
        .directive('empresaSelecao', empresaSelecao);

    empresaSelecao.$inject = ['$timeout'];
    function empresaSelecao($timeout) {
        // Usage:
        //     <empresa-selecao></empresa-selecao>
        // Creates:
        // 
        var directive = {
            restrict: 'EA',
            require: '^ngModel',
            templateUrl: 'app/empresa/components/selecao/empresa.selecao.html',
            controller: 'EmpresaSelecaoController',
            controllerAs: 'vm',
            bindToController: true,
            scope: {
                itemSelecionado: '=?',
                autoFocus: '=?'
            },
            link: link
        };  
        return directive;

        function link(scope, element, attrs, model) {
            scope.model = model;

            scope.updateValue = function (value) {
                $timeout(function () {
                    scope.model.$setViewValue(value);
                });
            };

            scope.$watch(function () {
                return model.$modelValue;
            }, function (newValue) {
                scope.vm.buscarInicial(newValue);
            });
        }
    }

})();