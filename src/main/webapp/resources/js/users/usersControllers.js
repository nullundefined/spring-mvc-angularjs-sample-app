var usersCOntrollers = angular.module('controllers', ['frontendServices']);

usersCOntrollers.controller('UsersCtrl', ['$scope', '$http', 'ContentService', function ($scope, $http, ContentService) {
    ContentService.getBasicContent().then(function (data) {
        $scope.content = data;
    });

    $scope.addContent = function () {
        console.log('add content');
    };

}]);

usersCOntrollers.controller('UsersDetailCtrl', ['$scope', '$http', '$routeParams', 'ContentService', function ($scope, $http, $routeParams, ContentService) {
    $scope.id = $routeParams.contentId;
    $scope.content = {};

    ContentService.getContentDetails($scope.id).then(function (data) {\s
        $scope.content = data;
    });

    $scope.save = function () {
        ContentService.save($scope.content, '/contents');
    }
}]);

appControllers.controller('DashboardCtrl', ['$scope', '$http', '$routeParams', 'DashboardService', function ($scope, $http, $routeParams, DashboardService) {
    $scope.dashboard = {};

    /*DashboardService.getDashboardData().then(function (data) {
        $scope.dashboard = data;
    });*/
}]);
