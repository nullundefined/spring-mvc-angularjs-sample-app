var usersControllers = angular.module('usersControllers', ['usersServices']);

usersControllers.controller('UsersCtrl', ['$scope', '$http', 'UsersService', function ($scope, $http, UsersService) {
    $scope.selectedUser = {};
    UsersService.findUsers().then(function (data) {
        $scope.users = data;
    });
    $scope.showDetails = function (item) {
        UsersService.selectUser(item);
       $location.path(view); // path not hash
    };

}]);

usersControllers.controller('UsersDetailCtrl', ['$scope', '$http', '$routeParams', 'UsersService', function ($scope, $http, $routeParams, UsersService) {
    $scope.selectedUser = UsersService.getSelectedUser()

    $scope.save = function () {
        //UsersService.save($scope.content, '/contents');
    }
}]);
