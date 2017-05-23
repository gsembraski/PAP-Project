(function () {
    'use strict';

    angular
        .module('app.pop')
        .run(appRun);

    appRun.$inject = ['routerHelper'];
    /* @ngInject */
    function appRun(routerHelper) {
        routerHelper.configureStates(getStates());
    }

    function getStates() {
        return [
            {
                state: 'app.pop',
                config: {
                    abstract: true,
                    url: '/pop',
                    templateUrl: 'app/pop/pop.html',
                    ncyBreadcrumb: {
                        label: 'POP'
                    }
                }
            },
            //route responsavel por listar pop
            {
                state: 'app.pop.listaTipo',
                config: {
                    url: '/listar-tipo',
                    templateUrl: 'app/pop/pop-listar-tipo.html',
                    controller: 'PopListarTipoController',
                    controllerAs: 'vm',
                    ncyBreadcrumb: {
                        label: 'POP'
                    }
                }
            },
            //route responsavel por listar pop cadastrados
            {
                state: 'app.pop.listar',
                config: {
                    url: '/listar/{popNum}',
                    templateUrl: 'app/pop/pop-listar.html',
                    controller: 'PopListarController',
                    controllerAs: 'vm',
                    ncyBreadcrumb: {
                        label: 'POP'
                    }
                }
            },
            //route  responsavel pela modificação de manual inseridos
            {
                state: 'app.pop.editar',
                config: {
                    url: '/editar/{id:int}',
                    templateUrl: 'app/pop/pop-detalhes.html',
                    controller: 'PopEditarController',
                    controllerAs: 'vm',
                    title: 'POP - Editar',
                    ncyBreadcrumb: {
                        label: 'Editar',
                        parent: 'app.manual.listar'
                    }
                }
            },
            //route responsavel pelo inserção de manual
            {
                state: 'app.pop.cadastrar',
                config: {
                    url: '/cadastrar/{popNum}',
                    templateUrl: 'app/pop/pop-detalhes.html',
                    controller: 'PopCadastrarController',
                    controllerAs: 'vm',
                    title: 'POP - Cadastrar',
                    ncyBreadcrumb: {
                        label: 'Cadastrar',
                        parent: 'app.pop.listar'
                    }
                }
            }
        ];
    }
})();
