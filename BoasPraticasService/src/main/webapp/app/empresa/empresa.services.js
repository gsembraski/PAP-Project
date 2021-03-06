(function () {
    'use strict';

    angular
        .module('app.empresa')
        .factory('empresaService', empresaService);
    
    empresaService.$inject = ['$http', '$q'];
	function empresaService($http, $q) {
	
		var api = 'rs/authenticad/api/empresa/';
		
		var service = {
				cadastrar: cadastrar,
				atualizar: atualizar,
				deletar: deletar,
				buscar: buscar,
				buscarItem: buscarItem
		};
		return service;
		
		function buscar(usuarioEmail){
            var req = {
                    method: 'GET',
                    url: api + usuarioEmail
                };
                
                return $http(req);
		}
		
		function buscarItem(id){
            var req = {
                    method: 'GET',
                    url: api + 'buscarItem/' + id
                };
                
                return $http(req);
		}
		
		function cadastrar(item){
			var url = api;

            return $http.post(url,angular.toJson(item));
		}
		
		function atualizar(item){
			var url = api + item.id;

            return $http.put(url, angular.toJson(item));
		}
		
		function deletar(id){
			var url = api + id;

            return $http.delete(url);
		}
	}
})();