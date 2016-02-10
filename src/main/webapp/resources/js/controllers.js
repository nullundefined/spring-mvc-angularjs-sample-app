var controllers = angular.module('controllers', ['frontendServices']);

controllers.controller('ContentCtrl', ['$scope', '$http', 'ContentService', function ($scope, $http, ContentService) {
    ContentService.getBasicContent().then(function (data) {
        $scope.content = data;
    });

    $scope.addContent = function () {
        console.log('add content');
    };

}]);

controllers.controller('ContentDetailsCtrl', ['$scope', '$http', '$routeParams', 'ContentService', function ($scope, $http, ContentService) {
    $scope.id = $routeParams.contentId;
    $scope.content = null;

    ContentService.getDetails($scope.id).then(function (data) {
        $scope.content = data();
    });
}]);
