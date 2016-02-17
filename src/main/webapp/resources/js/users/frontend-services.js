var appServices = angular.module('frontendServices', []);

appServices.service('ContentService', ['$http', '$q', '$location', function ($http, $q, $location) {
    return {
        getBasicContent: function () {
            var deferred = $q.defer();
            $http.get('content')
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve(response.data);
                    } else {
                        deferred.reject('Error retrieving list of meals');
                    }
                });
            return deferred.promise;
        },
        getContentDetails: function (id) {
            var deferred = $q.defer();
            $http.get('content/details/' + id)
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve(response.data);
                    } else {
                        deferred.reject('Error retrieving list of meals');
                    }
                });
            return deferred.promise;
        },
        save: function (data, view) {
            var deferred = $q.defer();
            $http.post('content/save', data)
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
        getUsers: function () {
            var deferred = $q.defer();
            $http.get('users')
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve(response.data);
                    } else {
                        deferred.reject('Error retrieving list of meals');
                    }
                });
            return deferred.promise;
        }
    }
}]);

appServices.service('UserService', ['$http', '$q', function ($http, $q) {
    return {
        getUserInfo: function () {
            var deferred = $q.defer();
            $http.get('/user')
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve(response.data);
                    }
                    else {
                        deferred.reject('Error retrieving user info');
                    }
                });
            return deferred.promise;
        },
        logout: function () {
            $http({
                method: 'POST',
                url: '/logout'
            })
                .then(function (response) {
                    if (response.status == 200) {
                        window.location.reload();
                    }
                    else {
                        console.log("Logout failed!");
                    }
                });
        }
    };
}]);

appServices.service('DashboardService', ['$http', '$q', '$location', function ($http, $q, $location) {
    return {
        fetchDasboardData: function () {
            var deferred = $q.defer();
            $http.get('/dashboard')
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve(response.data);
                    } else {
                        deferred.reject('Error retrieving list of meals');
                    }
                });
            return deferred.promise;
        }
    }
}]);