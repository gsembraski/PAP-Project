(function () {
    'use strict';

    angular
        .module('app.manual')
        .factory('manualServices', manualServices);

    manualServices.$inject = ['$http', '$q'];
	function manualServices($http, $q) {
	
		var api = 'http://localhost:8080/BoasPraticasService/rs/api/manual/';
		
		var service = {
				cadastrar: cadastrar,
				atualizar: atualizar,
				deletar: deletar,
				buscar: buscar,
				buscarItem: buscarItem
		};
		return service;
		
		function cadastrar(item){
			var url = api;

            return $http.post(url, angular.toJson(item));
		}
		
		function atualizar(item){
			var url = api + item.id;

            var deferred = $q.defer();

            return $http.put(url, angular.toJson(item));
        }
		
		function deletar(id){
			var url = api + id;

            return $http.delete(url);
		}
		
		function buscar(email){
            var req = {
                    method: 'GET',
                    url: api + email
                };

            return $http(req);
		}
		
		function buscarItem(id){
            var req = {
                    method: 'GET',
                    url: api + 'buscarItem/' +id
                };
                
                return $http(req);
		}
	}
})();