(function () {
	
    'use strict';

    appStorage.factory('storage', SessionStorage);    
    function SessionStorage($window) {
    	
        var storage = $window.localStorage;
        this.clear = function () {
            for (var i = storage.length - 1; i > 0; i--) {
                if (storage.key(i).indexOf('agenda:') === 0)
                    storage.removeItem(storage.key(i));
            }
        };
        this.hasKey = function (key) {
            return key in storage;
        };
        this.getItem = function (key) {
            return angular.fromJson(storage.getItem('agenda:' + key));
        };
        this.setItem = function (key, value) {
            if (value === null)
                storage.removeItem('agenda:' + key);
            else
                storage.setItem('agenda:' + key, angular.toJson(value));
        };
        this.removeItem = function (key) {
            storage.removeItem('agenda:' + key);
        };
        Object.defineProperty(this, 'length', { enumerable: true, get: function () { return storage.length; } });
        return this;
    }
});