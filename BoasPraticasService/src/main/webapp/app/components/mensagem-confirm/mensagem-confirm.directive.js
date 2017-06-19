; (function () {
    'use strict';

    angular
        .module('app.mensagem-confirm')
        .directive('mensagemConfirm', mensagemConfirm);

    mensagemConfirm.$inject = ['$uibModal'];
    function mensagemConfirm($uibModal) {
        // Usage:
        //     <TAG mps-confirm></TAG>
        // Creates:
        // 
        var directive = {
            priority: -1,
            restrict: 'A',
            link: function (scope, element, attrs) {
                element.bind('click', function (e) {
                    var message = attrs.mpsConfirm || 'Tem certeza que deseja excluir este item?';

                    if (attrs.mpsConfirmValidation) {
                        var valid = scope.$eval(attrs.mpsConfirmValidation);
                        if (!valid)
                            return;
                    }

                    e.stopImmediatePropagation();
                    e.preventDefault();

                    var modalInstance = $uibModal.open({
                        templateUrl: 'app/components/mensagem-confirm/mensagem-confirm-modal.html',
                        controller: 'MensagemConfirmController',
                        controllerAs: 'vm',
                        resolve: {
                            mensagem: function () {
                                return message;
                            }
                        }
                    });

                    modalInstance.result.then(function () {
                        scope.$eval(attrs.ngClick);
                    });
                });
            }
        };

        return directive;
    }

})();