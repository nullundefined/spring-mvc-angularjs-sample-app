var usersService = angular.module('usersServices', []);

usersService.service('UsersService', ['$http', '$q', '$location', function ($http, $q, $location) {
    var selectedUser = {};
    return {
        findUsers: function () {
            var deferred = $q.defer();
            $http.get('user/users')
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve(response.data);
                    } else {
                        deferred.reject('Error retrieving list of users');
                    }
                });
            return deferred.promise;
        },
        selectUser: function (item) {
            selectedUser = item;
        }
    }
}]);

usersService.service('RolesService', ['$http', '$q', '$location', function ($http, $q, $location) {
    var selectedUser = {};
    return {
        save: function (data, view) {
            var deferred = $q.defer();
            $http.post('roles/save', data)
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve();
                        $location.path(view); // path not hash
                    } else {
                        deferred.reject('Error retrieving list of meals');
                        $location.path(view); // path not hash
                    }
                });
            return deferred.promise;
        },
        findRoles: function () {
            var deferred = $q.defer();
            $http.get('roles')
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve(response.data);
                    } else {
                        deferred.reject('Error retrieving list of roles');
                    }
                });
            return deferred.promise;
        }
    }
}]);