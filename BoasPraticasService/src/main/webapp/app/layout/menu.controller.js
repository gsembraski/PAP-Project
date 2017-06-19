(function () {
    'use strict';

    angular
        .module('app.layout')
        .controller('MenuController', MenuController);

    MenuController.$inject = ['$uibModal', '$state', '$rootScope', '$window', 'routerHelper', 'seguranca'];
    /* @ngInject */
    function MenuController($uibModal, $state, $rootScope, $window, routerHelper, seguranca) {
        var vm = this;
        
        vm.itens = [

            {
 	            text: 'EMPRESA', 'class': "['fa fa-fw fa-users']", state: 'app.empresa.listar'
 	        },
        	{
	            text: 'MANUAL', 'class': "['fa fa-fw fa-book']", state: 'app.manual.listar'
	        },
           {
               text: 'POPs', 'class': "['fa fa-fw fa-cubes']", state: 'app.pop.listaTipo'
           }

        ];

        vm.storage = $window.localStorage;
        vm.user = "";

        vm.abrirModalEditar = abrirModalEditar;
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
		
		function abrirModalEditar(){
			$uibModal.open({
			      templateUrl: 'app/usuario/modal/modal-usuario.html',
			      size: 'md',
			      controller: 'UsuarioEditarController',
			      controllerAs: 'vm',
			      backdrop: 'static',
			      resolve: {
			    	  params:{email: vm.user.login}
			      }
				});
		}

        function sair() {
            seguranca.logout();
            $state.go('home');
        }

        function usuario() {
        	vm.user = angular.fromJson(vm.storage.getItem('security'));
            if(vm.user)
            	return vm.user.login;
            return '';
        }
        
        activate();
        
        function activate(){
        	
        }
    }
})();


