(function () {
    'use strict';

    angular
        .module('app.empresa')
        .run(appRun);

    appRun.$inject = ['routerHelper', 'nivelAcesso', 'recursos'];
    /* @ngInject */
    function appRun(routerHelper, nivelAcesso, recursos) {
        routerHelper.configureStates(getStates(nivelAcesso, recursos));
    }

    function getStates(nivelAcesso, recursos) {
        return [
            {
                state: 'app.empresa',
                config: {
                    abstract: true,
                    url: '/empresa',
                    templateUrl: 'app/empresa/empresa.html',
                    ncyBreadcrumb: {
                        label: 'Empresa'
                    },
                    data: {
                        permission: {
                            resource: recursos.mbp,
                            level: nivelAcesso.SELECIONAR
                        }
                    }
                }
            },
            //route responsavel por listar empresa cadastrados
            {
                state: 'app.empresa.listar',
                config: {
                    url: '/listar',
                    templateUrl: 'app/empresa/empresa-listar.html',
                    controller: 'EmpresaListarController',
                    controllerAs: 'vm'
                }
            },
            //route  responsavel pela modificação de empresa inseridos
            {
                state: 'app.empresa.editar',
                config: {
                    url: '/editar/{id:int}',
                    templateUrl: 'app/empresa/empresa-detalhes.html',
                    controller: 'EmpresaEditarController',
                    controllerAs: 'vm',
                    title: 'Empresa - Editar'
                }
            },
            //route responsavel pelo inserção de empresa
            {
                state: 'app.empresa.cadastrar',
                config: {
                    url: '/cadastrar',
                    templateUrl: 'app/empresa/empresa-detalhes.html',
                    controller: 'EmpresaCadastrarController',
                    controllerAs: 'vm',
                    title: 'Empresa - Cadastrar'
                }
            }
        ];
    }
})();
