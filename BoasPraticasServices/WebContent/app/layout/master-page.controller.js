(function () {
    'use strict';

    angular
        .module('app.layout')
        .controller('MasterPageController', MasterPageController);

    MasterPageController.$inject = [];
    /* @ngInject */
    function MasterPageController() {
        var vm = this;
        vm.navline = {
            title: 'Guia de Boas Práticas no Serviço de Alimentação',
        };
    }
})();
