(function () {
    'use strict';

    angular
        .module('app.pop')
        .factory('popServices', popServices);

    popServices.$inject = ['$http', '$q', '$filter'];
	function popServices($http, $q, $filter) {
	
		var api = 'rs/authenticad/api/pop/';
		
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
		
		function download(id, popNum){
            var req = {
                    method: 'GET',
                    url: api + 'gerarPop/' +id,
                    responseType: 'blob'
                };
                
                return $http(req).then(function (response) {
                	var data = new $filter('date')(new Date(),'dd-MM-yyyy');

                	var blob = new Blob([response.data], {type: "application/octet-stream"});
                	saveAs(blob, "pop" + popNum + "-" + data +".docx");
                });
		}
	}
})();