(function () {
    'use strict';

    angular
        .module('app.layout')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'home',
                config: {
                    url: ['', '/', '/index', '/home'],
                    templateUrl: 'app/layout/pagina-inicial.html',
                    controller: 'PaginaInicialController',
                    controllerAs: 'vm'
                }
            },
            {
                state: 'app',
                config: {
                    abstract: true,
                    template: '<ui-view/>',
                    data: {
                        requireAuthorization: false
                    }
                }
            },
        ];
    }
})();
