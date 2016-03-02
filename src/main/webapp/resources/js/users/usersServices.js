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
                        deferred.reject('Error retrieving list of meals');
                    }
                });
            return deferred.promise;
        },
        selectUser: function (item) {
            selectedUser = item;
        }
    }
}]);