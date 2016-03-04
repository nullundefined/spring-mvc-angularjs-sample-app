var usersApp = angular.module('usersApp', ['spring-security-csrf-token-interceptor', 'ngRoute', 'ngMessages', 'usersControllers']);

usersApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
        when('/users', {
            templateUrl: '/resources/partials/users/users-list.html',
            controller: 'UsersCtrl'
        }).when('/user/:selectedUserIndex', {
            templateUrl: 'resources/partials/users/users-profile.html',
            controller: 'UsersProfileCtrl'
        }).when('/roles', {
            templateUrl: 'resources/partials/users/roles-list.html',
            controller: 'RolesCtrl'
        }).when('/role/:selectedRoleIndex', {
            templateUrl: 'resources/partials/users/roles-details.html',
            controller: 'RoleDetailsCtrl'
        }).otherwise({
            redirectTo: '/users'
        });
    }]);