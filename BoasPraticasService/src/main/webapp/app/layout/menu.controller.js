(function () {
    'use strict';

    angular
        .module('app.layout')
        .controller('MenuController', MenuController);

    MenuController.$inject = ['$state', '$rootScope', '$window', 'routerHelper', 'seguranca'];
    /* @ngInject */
    function MenuController($state, $rootScope, $window, routerHelper, seguranca) {
        var vm = this;
        
        vm.itens = [
	        {
	            text: 'MANUAL', 'class': "['fa fa-fw fa-book']", state: 'app.manual.listar'
	        },
           {
               text: 'POPs', 'class': "['fa fa-fw fa-cubes']", state: 'app.pop.listaTipo'
           },
           {
	            text: 'EMPRESA', 'class': "['fa fa-fw fa-users']", state: 'app.empresa.listar'
	        }

        ];

        vm.storage = $window.localStorage;

        vm.autenticado = autenticado;
        vm.entrar = entrar;
        vm.sair = sair;
        vm.usuario = usuario;

        function autenticado() {
            return seguranca.authenticated;
        }

        function entrar() {
            $state.go('login');
        }

        function sair() {
            seguranca.logout();
            $state.go('home');
        }

        function usuario() {
            var user = angular.fromJson(vm.storage.getItem('security'));
            if(user)
            	return user.login;
            return '';
        }
        
        activate();
        
        function activate(){
        	
        }
    }
})();


