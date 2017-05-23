(function () {
    'use strict';

    angular
        .module('app.manual')
        .factory('manualServices', manualServices);

    manualServices.$inject = ['$http', '$q', '$filter'];
	function manualServices($http, $q, $filter) {
	
		var api = 'rs/authenticad/api/manual/';
		
		var service = {
				cadastrar: cadastrar,
				atualizar: atualizar,
				deletar: deletar,
				buscar: buscar,
				buscarItem: buscarItem,
				download: download
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
		
		function download(id){
            var req = {
                    method: 'GET',
                    url: api + 'gerarManual/' +id,
                    responseType: 'blob'
                };
                
                return $http(req).then(function (response) {
                	var data = new $filter('date')(new Date(),'dd-MM-yyyy');

                	var blob = new Blob([response.data], {type: "application/octet-stream"});
                	saveAs(blob, "mbp-"+ data +".docx");
                });
		}
	}
})();