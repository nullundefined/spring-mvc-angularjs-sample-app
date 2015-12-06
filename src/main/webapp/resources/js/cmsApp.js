var cmsApp = angular.module('cmsApp', ['ngRoute', 'ngMessages', 'common', 'cmsControllers']);

cmsApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/contents', {
                templateUrl: '/resources/partials/contents.html',
                controller: 'ContentCtrl'
            }).
            when('/content/:contentId', {
                templateUrl: 'resources/partials/content-detail.html',
                controller: 'ContentCtrl'
            }).
            otherwise({
                redirectTo: '/contents'
            });
    }]);

