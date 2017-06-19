(function () {
    'use strict';

    angular
        .module('app.autoFocus')
        .directive('autoFocus', autoFocus);

    autoFocus.$inject = ['$timeout'];
    function autoFocus($timeout) {
        // Usage:
        //     <TAG auto-focus></TAG>
        var directive = {
            restrict: 'A',
            link: function ($scope, $element, $attrs) {
                $scope.$watch(function () {
                    return $scope.$eval($attrs.autoFocus);
                }, function (newValue) {
                    if ($scope.$eval($attrs.autoFocus) || $attrs.autoFocus == '')
                        $timeout(function () { $element[0].focus(); });
                });
            }
        };

        return directive;
    }

})();