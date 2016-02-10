var cmsApp = angular.module('cmsApp', ['ngRoute', 'ngMessages', 'common', 'controllers']);

cmsApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/contents', {
                templateUrl: '/resources/partials/contents.html',
                controller: 'ContentCtrl'
            }).
            when('/content/details/:contentId', {
                templateUrl: 'resources/partials/content-detail.html',
                controller: 'ContentDetailsCtrl'
            }).
            otherwise({
                redirectTo: '/contents'
            });
    }]);

