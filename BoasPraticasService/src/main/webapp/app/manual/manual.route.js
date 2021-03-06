(function () {
    'use strict';

    angular
        .module('app.manual')
        .run(appRun);

    appRun.$inject = ['routerHelper', 'nivelAcesso', 'recursos'];
    /* @ngInject */
    function appRun(routerHelper, nivelAcesso, recursos) {
        routerHelper.configureStates(getStates(nivelAcesso, recursos));
    }

    function getStates(nivelAcesso, recursos) {
        return [
            {
                state: 'app.manual',
                config: {
                    abstract: true,
                    url: '/manual',
                    templateUrl: 'app/manual/manual.html',
                    ncyBreadcrumb: {
                        label: 'Manual'
                    },
                    data: {
                        permission: {
                            resource: recursos.mbp,
                            level: nivelAcesso.SELECIONAR
                        }
                    }
                }
            },
            //route responsavel por listar manual cadastrados
            {
                state: 'app.manual.listar',
                config: {
                    url: '/listar',
                    templateUrl: 'app/manual/manual-listar.html',
                    controller: 'ManualListarController',
                    controllerAs: 'vm',
                    ncyBreadcrumb: {
                        label: 'Manual'
                    }
                }
            },
            //route  responsavel pela modificação de manual inseridos
            {
                state: 'app.manual.editar',
                config: {
                    url: '/editar/{id:int}',
                    templateUrl: 'app/manual/manual-detalhes.html',
                    controller: 'ManualEditarController',
                    controllerAs: 'vm',
                    title: 'Manual - Editar',
                    ncyBreadcrumb: {
                        label: 'Editar',
                        parent: 'app.manual.listar'
                    }
                }
            },
            //route responsavel pelo inserção de manual
            {
                state: 'app.manual.cadastrar',
                config: {
                    url: '/cadastrar',
                    templateUrl: 'app/manual/manual-detalhes.html',
                    controller: 'ManualCadastrarController',
                    controllerAs: 'vm',
                    title: 'Manual - Cadastrar',
                    ncyBreadcrumb: {
                        label: 'Cadastrar',
                        parent: 'app.manual.listar'
                    }
                }
            }
        ];
    }
})();
