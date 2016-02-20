var usersControllers = angular.module('controllers', ['frontendServices']);

usersControllers.controller('UsersCtrl', ['$scope', '$http', 'UsersService', function ($scope, $http, ContentService) {
    $scope.selectedUser = {};
    UsersService.findUsers().then(function (data) {
        $scope.users = data;
    });
    $scope.showDetails = function (item) {
        UsersService.selectUser(item);
       $location.path(view); // path not hash
    };

}]);

usersControllers.controller('UsersDetailCtrl', ['$scope', '$http', '$routeParams', 'ContentService', function ($scope, $http, $routeParams, ContentService) {
    $scope.selectedUser = UsersService.getSelectedUser()

    $scope.save = function () {
        //UsersService.save($scope.content, '/contents');
    }
}]);
