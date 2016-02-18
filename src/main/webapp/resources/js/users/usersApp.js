var usersApp = angular.module('usersApp', ['spring-security-csrf-token-interceptor', 'ngRoute', 'ngMessages', 'common', 'controllers']);

usersApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
        when('/users', {
            templateUrl: '/resources/partials/users/users-list.html',
            controller: 'UsersCtrl'
        }).when('/users/:userIndex', {
            templateUrl: 'resources/partials/users/users-profile.html',
            controller: 'UsersProfileCtrl'
        }).otherwise({
            redirectTo: '/users'
        });
    }]);

