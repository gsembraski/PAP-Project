(function () {
    'use strict';

    angular
        .module('app.pop')
        .factory('popServices', popServices);

    popServices.$inject = ['$http', '$q'];
	function popServices($http, $q) {
	
		var api = 'rs/authenticad/api/pop/';
		
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
		
		function buscar(popNum, email){
            var req = {
                    method: 'GET',
                    url: api + popNum + '/' + email
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