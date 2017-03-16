var appHome = angular.module('app.home', ['app.core', 
                                          'app.manual',
                                          'app.storage']);

appHome.config(function($stateProvider, $locationProvider) {
	 $locationProvider.html5Mode(false).hashPrefix('!');
	
	 $stateProvider.state( 'home',{
	    url: '/home',
	    templateUrl: 'app/home/home.html',
	    controller: 'HomeController',
	    controllerAs: 'vm'
	  });

	  $stateProvider
	    .state('manual',{
			  	abstract: true,	
				url: '/manual',
				templateUrl: 'app/manual/manual.html'
	    })
	    .state('manual.listar',{
			  	url: '/listar',
			  	templateUrl: 'app/manual/manual-listar.html',
			    controller: 'ManualListarController',
			    controllerAs: 'vm'	  		 
	    })
	    .state('manual.cadastrar',{
			  	url: '/cadastrar',
			  	templateUrl: 'app/manual/manual-detalhes.html',
			    controller: 'ManualCadastrarController',
			    controllerAs: 'vm'
	    });
});