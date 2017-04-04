(function () {
    'use strict';

    angular
        .module('app.manual')
        .controller('ManualEditarController', ManualEditarController);
	
	function ManualEditarController($state){
		var vm = this;
		
		vm.manual = {};
		
	}
})();