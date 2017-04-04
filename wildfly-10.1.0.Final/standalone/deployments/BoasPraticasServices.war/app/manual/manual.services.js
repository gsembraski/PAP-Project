(function () {
    'use strict';

    angular
        .module('app.manual')
        .factory('manualServices', manualServices)
	function manualServices($http, $q) {
	
		var api = 'http://localhost:8080/BoasPraticas/rest/manual/';
		
		var service = {
				cadastrar: cadastrar,
				atualizar: atualizar,
				deletar: deletar,
				buscar: buscar
		};
		return service;
		
		function cadastrar(item){
			var url = api + 'teste@teste';

            var deferred = $q.defer();

            $http.post(url, angular.toJson(item)).success(function (data, status, headers, config) {
            	   deferred.resolve(true);
            }).error(function(){
            	deferred.resolve(false);
            });
            return deferred.promise;
		}
		
		function atualizar(item){
			var url = api + item.id;

            var deferred = $q.defer();

            $http.put(url, angular.toJson(item)).success(function (data, status, headers, config) {
                deferred.resolve(true);
            }).error(function(){
            	deferred.resolve(false);
            });
            return deferred.promise;
		}
		
		function deletar(id){
			var url = api + id;

            var deferred = $q.defer();

            $http.delete(url).success(function (data, status, headers, config) {
                deferred.resolve(data);
            });
            return deferred.promise;
		}
		
		function buscar(email){
            var req = {
                    method: 'GET',
                    url: api + email
                };
                var deferred = $q.defer();

                $http(req).success(function (data, status, headers, config) {
                    deferred.resolve(angular.fromJson(data));
                });
                return deferred.promise;
		}
	}
})();