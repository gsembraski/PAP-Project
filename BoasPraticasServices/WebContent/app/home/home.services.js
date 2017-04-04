(function () {
    'use strict';

    angular
        .module('app.manual')
        .factory('homeServices', homeServices)
	function homeServices($http, $q) {
	
		var api = 'http://localhost:8080/BoasPraticasServices/rs/api/usuario/';
		
		var service = {
				logar: logar,
				verificarEmail: verificarEmail,
				cadastrar: cadastrar,
				atualizar: atualizar,
				deletar: deletar,
				buscar: buscar,
				existeEmail: existeEmail
		};
		return service;
		
		function logar(item){
			var url = api + 'logar/';
			
			item.id = null;
			


            return $http.put(url, angular.toJson(item));
		}        
		
		function existeEmail(email) {
            var req = {
                method: 'GET',
                url: api + email
            };
            
            return $http(req);;
        }
		
		function verificarEmail(){
			
		}
		
		function cadastrar(item){
			var url = api;
            
            item.id = null;
            item.ultimoAcesso = null;

            return $http.post(url, angular.toJson(item));
		}
		
		function atualizar(){
			
		}
		
		function deletar(){
			
		}
		
		function buscar(){
			
		}
	}
})();