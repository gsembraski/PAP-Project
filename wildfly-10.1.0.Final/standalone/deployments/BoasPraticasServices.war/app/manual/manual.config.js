	appManual.provider('router',function($stateProvider, $locationProvider) {

		 $locationProvider.html5Mode(false).hashPrefix('!');
		/*$stateProvider
	    .state('manual',{
			  	abstract: true,	
				url: '/manual',
				templateUrl: 'app/manual/manual.html'
	    },
	    .state('manual.listar',{
			  	url: '/listar',
			  	templateUrl: 'app/manual/manual-listar.html',
			    controller: 'ManualListarController',
			    controllerAs: 'vm'	  		 
	    },
	    .state('manual.cadastrar',{
			  	url: '/cadastrar',
			  	templateUrl: 'app/manual/manual-detalhes.html',
			    controller: 'ManualCadastrarController',
			    controllerAs: 'vm'
	    })*/
	})
