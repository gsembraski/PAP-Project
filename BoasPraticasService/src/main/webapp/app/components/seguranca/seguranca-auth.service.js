(function () {
    'use strict';

    angular
        .module('app.seguranca')
        .factory('segurancaAuthService', dataservice);

    dataservice.$inject = ['$http', '$window'];
    /* @ngInject */
    function dataservice($http, $window) {
        var service = {
            realizarLogin: realizarLogin
        };

        return service;

        function realizarLogin(username, password) {
        	/*var credenciais = $window.btoa(username + ':' + password);
            var config = { headers: { Authorization: 'Basic ' + credenciais, 'X-Requested-With': 'XMLHttpRequest' } };
            var url = 'api/seguranca/autenticacao';

            return $http.get(url, config);*/
        }
    }
})();