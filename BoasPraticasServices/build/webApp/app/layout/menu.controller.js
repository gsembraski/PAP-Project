(function () {
    'use strict';

    angular
        .module('app.layout')
        .controller('MenuController', MenuController);

    MenuController.$inject = ['$state', '$rootScope', 'routerHelper'];
    /* @ngInject */
    function MenuController($state, $rootScope, routerHelper) {
        var vm = this;
        vm.itens = [
	        {
	            text: 'MANUAL', 'class': "['fa fa-fw fa-book']", state: 'app.manual.listar'
	        },
           {
               text: 'POPs', 'class': "['fa fa-fw fa-cubes']", itens: [
               ]
           },
           {
	            text: 'EMPRESA', 'class': "['fa fa-fw fa-users']", state: 'app.empresa.listar'
	        }

        ];

        vm.autenticado = autenticado;
        vm.entrar = entrar;
        vm.sair = sair;
        vm.usuario = usuario;

        function autenticado() {
            return true;//seguranca.authenticated;
        }

        function entrar() {
            $state.go('login');
        }

        function sair() {
            //seguranca.logout();
            $state.go('inicio');
        }

        function usuario() {
            return 'Geovana Sembraski Nocera';
        }
    }
})();


