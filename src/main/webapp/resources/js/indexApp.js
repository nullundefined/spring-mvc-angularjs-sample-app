angular.module('indexApp', ['common', 'spring-security-csrf-token-interceptor'])
    .controller('ContentCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.content = [{id:1, type:'footer', timestamp: new Date()}, {id:1, type:'header', timestamp: new Date()}, {id:1, type:'general', timestamp: new Date()}];
        $scope.addContent = function () {
            console.log('add content');

        };

    }]);