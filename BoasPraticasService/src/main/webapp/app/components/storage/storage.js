(function () {
    'use strict';

    angular
        .module('blocks.storage')
        .factory('storage', SessionStorage);

    SessionStorage.$inject = ['$window'];
    /* @ngInject */
    function SessionStorage($window) {
        var storage = $window.localStorage;
        this.clear = function () {
            for (var i = storage.length - 1; i > 0; i--) {
                if (storage.key(i).indexOf('mbp:') === 0)
                    storage.removeItem(storage.key(i));
            }
        };
        this.hasKey = function (key) {
            return key in storage;
        };
        this.getItem = function (key) {
            return angular.fromJson(storage.getItem('mbp:' + key));
        };
        this.setItem = function (key, value) {
            if (value === null)
                storage.removeItem('mbp:' + key);
            else
                storage.setItem('mbp:' + key, angular.toJson(value));
        };
        this.removeItem = function (key) {
            storage.removeItem('mbp:' + key);
        };
        Object.defineProperty(this, 'mbp', { enumerable: true, get: function () { return storage.length; } });
        return this;
    }
})();