'use strict';

angular
    .module('betterApp', [
        'ngResource',
        'ngRoute',
        'ngSanitize',
        'ngTouch',
        'ui.router'
    ])
    .config(function ($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('home', {
                url: '/',
                views: {
                    'content@': {
                        templateUrl: 'pages/frontside/main.html',
                        controller: 'MainFrontCtrl'
                    },
                    'navbar@' : {
                        templateUrl: 'pages/frontside/navbar.html',
                        controller: 'NavbarFrontCtrl'
                    }
                }
            });

        $urlRouterProvider.otherwise('/');


    })
    .run(function($rootScope) {

    });
