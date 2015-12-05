angular.module('indexApp', ['common', 'frontendServices', 'spring-security-csrf-token-interceptor'])
    .controller('ContentCtrl', ['$scope', '$http', 'ContentService', function ($scope, $http, ContentService) {
        //$scope.content = [{id:1, type:'footer', timestamp: new Date()}, {id:1, type:'header', timestamp: new Date()}, {id:1, type:'general', timestamp: new Date()}];
        // $scope.content = $http.get('/content.json');

        ContentService.getBasicContent().then(function (data) {
            $scope.content = data;
        });
        $scope.addContent = function () {
            console.log('add content');

        };

    }]);