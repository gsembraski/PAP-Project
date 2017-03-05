(function() {

	'use strict';
	
	appHome.factory('homeServices', homeServices)
	function homeServices($http, $q) {
	
		var api = 'http://localhost:8080/BoasPraticasServices/rs/api/usuario/';
		
		var service = {
				logar: logar,
				verificarEmail: verificarEmail,
				cadastrar: cadastrar,
				atualizar: atualizar,
				deletar: deletar,
				buscar: buscar
		};
		return service;
		
		function logar(item){
			var url = api + 'logar/';
			
			item.id = null;
			

            var deferred = $q.defer();

            $http.put(url, angular.toJson(item)).success(function (data, status, headers, config) {
                deferred.resolve(data);
            });
            return deferred.promise;
		}
		
		function verificarEmail(){
			
		}
		
		function cadastrar(item){
			var url = api;

            var deferred = $q.defer();
            
            item.id = null;
            item.ultimoAcesso = null;

            $http.post(url, angular.toJson(item)).success(function (data, status, headers, config) {
                deferred.resolve(data);
            });
            return deferred.promise;
		}
		
		function atualizar(){
			
		}
		
		function deletar(){
			
		}
		
		function buscar(){
			
		}
	}
})();