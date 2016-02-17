var cmsApp = angular.module('cmsApp', ['spring-security-csrf-token-interceptor', 'ngRoute', 'ngMessages', 'common', 'controllers']);

cmsApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
        when('/contents', {
            templateUrl: '/resources/partials/contents.html',
            controller: 'ContentCtrl'
        }).when('/content/details/:contentId', {
            templateUrl: 'resources/partials/content-detail.html',
            controller: 'ContentDetailsCtrl'
        }).when('/dashboard', {
            templateUrl: '/resources/partials/dashboard.html',
            controller: 'DashboardCtrl'
        }).when('/orders', {
            templateUrl: '/resources/partials/orders.html',
            controller: 'DashboardCtrl'
        }).when('/users', {
            templateUrl: '/resources/partials/users.html',
            controller: 'DashboardCtrl'
        }).otherwise({
            redirectTo: '/contents'
        });
    }]);
