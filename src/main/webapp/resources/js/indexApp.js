angular.module('indexApp', ['common', 'spring-security-csrf-token-interceptor'])
    .controller('ContentCtrl', ['$scope', '$http', function ($scope, $http) {

        $scope.addContent = function () {
            console.log('add content');

        };

    }]);