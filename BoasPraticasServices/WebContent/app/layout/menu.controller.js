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
                   { text: 'Turnos', state: 'app.turno.listar', 'class': "['fa fa-fw fa-clock-o']" },
                   { text: 'Faixas Etárias', state: 'app.faixaEtaria.listar', 'class': "['fa fa-fw fa-child']" },
                   { text: 'Motivos', state: 'app.tipoMotivoAgendamento.listar', 'class': "['fa fa-fw']" }
               ]
           },
           {
	            text: 'EMPRESA', 'class': "['fa fa-fw fa-users']"//, state: 'app.agendamento.selecionar'
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


