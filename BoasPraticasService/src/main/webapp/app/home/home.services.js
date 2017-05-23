(function () {
    'use strict';

    angular
        .module('app.manual')
        .factory('homeServices', homeServices)
	function homeServices($http, $q) {
	
		var api = 'rs/api/usuario/';
		
		var service = {
				logar: logar,
				cadastrar: cadastrar,
				atualizar: atualizar,
				deletar: deletar,
				buscar: buscar,
				existeEmail: existeEmail
		};
		return service;
		
		function logar(item){
			var url = api + 'logar/';
			
            return $http.put(url, angular.toJson(item));
		}        
		
		function existeEmail(email) {
            var req = {
                method: 'GET',
                url: api + email
            };
            
            return $http(req);
        }
		
		function cadastrar(item){
			var url = api;

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