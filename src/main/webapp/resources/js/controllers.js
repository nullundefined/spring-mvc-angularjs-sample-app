var appControllers = angular.module('controllers', ['frontendServices']);

appControllers.controller('ContentCtrl', ['$scope', '$http', 'ContentService', function ($scope, $http, ContentService) {
    ContentService.getBasicContent().then(function (data) {
        $scope.content = data;
    });

    $scope.addContent = function () {
        console.log('add content');
    };

}]);

appControllers.controller('ContentDetailsCtrl', ['$scope', '$http', '$routeParams', 'ContentService', function ($scope, $http, $routeParams, ContentService) {
    $scope.id = $routeParams.contentId;
    $scope.content = null;

    ContentService.getContentDetails($scope.id).then(function (data) {
        $scope.content = data;
    });

    /*ContentService.save().then(function (data) {

        $scope.changeView('/contents');
    });*/
}]);
