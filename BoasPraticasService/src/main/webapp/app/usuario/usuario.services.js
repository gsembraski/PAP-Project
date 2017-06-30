(function () {
    'use strict';

    angular
        .module('app.usuario')
        .factory('usuarioServices', usuarioServices)
	function usuarioServices($http, $q) {
	
		var api = 'rs/api/usuario/';
		
		var service = {
				logar: logar,
				cadastrar: cadastrar,
				atualizar: atualizar,
				deletar: deletar,
				buscar: buscar,
				buscarItem: buscarItem,
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
		
		function atualizar(item){
			var url = api + item.id;

            var deferred = $q.defer();

            return $http.put(url, angular.toJson(item));
		}
		
		function deletar(email){
            var url = api + email;

            var deferred = $q.defer();

            return $http.delete(url);
		}
		
		function buscar(){
			
		}
		
		function buscarItem(email){
            var req = {
                    method: 'GET',
                    url: api + 'buscarItem/' + email
                };
                
                return $http(req);
		}
	}
})();