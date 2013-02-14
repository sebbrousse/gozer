'use strict';


// Declare app level module which depends on filters, and services
//angular.module('gozerApp', ['gozerApp.filters', 'gozerApp.services', 'gozerApp.directives']).
//  config(['$routeProvider', function($routeProvider) {
//        $routeProvider.when('/', {
//                controller: 'ProjectController',
//                templateUrl: 'views/project.html'
//            });
//        $routeProvider.otherwise({redirectTo: '/view1'});
//  }]);

var gozerApp = angular.module('gozerApp', []);

gozerApp.config(function($routeProvider) {

    $routeProvider.when('/project', {
        controller: 'ProjectController',
        templateUrl: 'views/project.html'
    });
    $routeProvider.when('/console', {
        controller: 'ConsoleController',
        templateUrl: 'views/console.html'
    });
    $routeProvider.otherwise({redirectTo: '/'});
});
