var usersControllers = angular.module('usersControllers', ['usersServices']);

usersControllers.controller('UsersCtrl', ['$scope', '$http', 'UsersService', function ($scope, $http, UsersService) {
    $scope.selectedUser = {};
    UsersService.findUsers().then(function (data) {
        $scope.users = data;
    });
}]);

usersControllers.controller('UsersProfileCtrl', ['$scope', '$http', '$routeParams', 'UsersService', function ($scope, $http, $routeParams, UsersService) {
    var selectedUserIndex = $routeParams.selectedUserIndex;


    //$scope.selectedUser = UsersService.getSelectedUser();

    $scope.save = function () {
        //UsersService.save($scope.content, '/contents');
    }
}]);


usersControllers.controller('RolesCtrl', ['$scope', '$http', 'RolesService', function ($scope, $http, RolesService) {
    /*$scope.roles = [
     {id: 1, name: 'admin_role', desc: 'Full system administrators', active: 1},
     {id: 2, name: 'payments_role', desc: 'Matching list operators', active: 1},
     {id: 3, name: 'content_role', desc: 'Content managers. E.g. LBS management, CMS management...', active: 1},
     {id: 3, name: 'lbs_role', desc: 'LBS management', active: 1}
     ];*/

    RolesService.findRoles().then(function (data) {
        $scope.roles;
    });
}]);

usersControllers.controller('RoleDetailsCtrl', ['$scope', '$http', '$routeParams', 'RolesService', function ($scope, $http, $routeParams, RolesService) {
    $scope.roles = [
        {id: 1, name: 'admin_role', desc: 'Full system administrators', active: 1},
        {id: 2, name: 'payments_role', desc: 'Matching list operators', active: 1},
        {id: 3, name: 'content_role', desc: 'Content managers. E.g. LBS management, CMS management...', active: 1},
        {id: 3, name: 'lbs_role', desc: 'LBS management', active: 1}
    ];

    $scope.users = [
        {
            userId: "test",
            userName: "test username",
            firstName: "",
            lastName: "",
            fullName: ""
        }
    ];

    var index = $routeParams.selectedRoleIndex;
    $scope.role = $scope.roles[index];


    $scope.save = function () {
        RolesService.save($scope.role, '/roles');
    }

}]);

