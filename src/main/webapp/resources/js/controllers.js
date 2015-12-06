var cmsControllers = angular.module('cmsControllers', ['frontendServices']);

cmsControllers.controller('ContentCtrl', ['$scope', '$http', 'ContentService', function ($scope, $http, ContentService) {
    ContentService.getBasicContent().then(function (data) {
        $scope.content = data;
    });
    $scope.addContent = function () {
        console.log('add content');
    };
}]);
