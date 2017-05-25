(function () {
    'use strict';

    angular
        .module('app.seguranca')
        .factory('seguranca', seguranca);

    seguranca.$inject = ['$http', '$timeout', '$window', '$rootScope', 'segurancaAuthService', 'AUTH_EVENTS'];
    /* @ngInject */
    function seguranca($http, $timeout, $window, $rootScope, segurancaAuthService, AUTH_EVENTS) {
        var user = null;
    	var storage = $window.localStorage;
        
        function getUser() {
            /*if (user === null) {
                var stored = storage.getItem('security');
                if (angular.isObject(stored) && angular.isString(stored.name) && angular.isString(stored.token))
                    user = stored;
            }
            if (user !== null) {
                var permissionToken = decodeJWT(user.token);
                if (permissionToken === null)
                    return null;
            }*/
        	//alterar
            return user = angular.fromJson(storage.getItem('security'));
        }
        
        function setUser(value) {
        	storage.setItem('security', value);
            user = value;
        }
        
        function decodeJWT(codedToken) {
            var expr = /^([^\.\s]*)\.([^\.\s]+)\.([^\.\s]*)$/;
            var parts = expr.exec(codedToken);
            if (!parts || parts.length != 4)
                return null;
            var decodedToken = {
                cabecalho: angular.fromJson($window.atob(parts[1])),
                conteudo: angular.fromJson($window.atob(parts[2])),
                assinatura: parts[3]
            };
            if (Math.round(new Date().getTime() / 1000) > decodedToken.conteudo.exp)
                return null;
            return decodedToken;
        }

        var api = {
            get authenticated() {
                return getUser() !== null;
            },
            get username() {
                var user = getUser();
                return user !== null ? user.name : '';
            },
            get token() {
                var user = getUser();
                return user !== null ? user.token : '';
            },
            login: function (username, password, callback) {
                setUser(null);

                segurancaAuthService
                    .realizarLogin(username, password)
                    .then(function (response) {
                        setUser({
                            name: username,
                            token: response.data.token
                        });
                        $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
                    }).catch(function (d) {
                        $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
                    }).finally(function () {
                        if (angular.isFunction(callback))
                            $timeout(function () { callback(getUser() !== null); });
                    });
            },
            logout: function (callback) {
                setUser(null);
                /*if (angular.isFunction(callback))
                    $timeout(function () { callback(true); });
                $rootScope.$broadcast(AUTH_EVENTS.logoutSuccess);*/
            }
        };

        return api;
    }
})();



