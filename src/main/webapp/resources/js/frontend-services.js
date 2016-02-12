angular.module('frontendServices', [])
    .service('ContentService', ['$http', '$q', function ($http, $q) {
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
            }, save: function (data) {
                var deferred = $q.defer();
                $http.post('content/save', data )
                    .then(function (response) {
                        if (response.status == 200) {
                            deferred.resolve();
                        } else {
                            deferred.reject('Error retrieving list of meals');
                        }
                    });

                /*$http.post('save', data)
                    .then(function (response) {
                        if (response.status == 200) {

                        } else {
                            deferred.reject('Error retrieving list of meals');
                        }
                    });*/

                return deferred.promise;
            }
            ,
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
            /*,

             deleteMeals: function(deletedMealIds) {
             var deferred = $q.defer();

             $http({
             method: 'DELETE',
             url: '/meal',
             data: deletedMealIds,
             headers: {
             "Content-Type": "application/json"
             }
             })
             .then(function (response) {
             if (response.status == 200) {
             deferred.resolve();
             }
             else {
             deferred.reject('Error deleting meals');
             }
             });

             return deferred.promise;
             },

             saveMeals: function(dirtyMeals) {
             var deferred = $q.defer();

             $http({
             method: 'POST',
             url: '/meal',
             data: dirtyMeals,
             headers: {
             "Content-Type": "application/json",
             "Accept": "text/plain, application/json"
             }
             })
             .then(function (response) {
             if (response.status == 200) {
             deferred.resolve();
             }
             else {
             deferred.reject("Error saving meals: " + response.data);
             }
             });

             return deferred.promise;
             }*/
        }
    }])
    .service('UserService', ['$http', '$q', function ($http, $q) {
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
            updateMaxCaloriesPerDay: function (maxCaloriesPerDay) {
                var deferred = $q.defer();

                $http.put('/user', maxCaloriesPerDay)
                    .then(function (response) {
                        if (response.status == 200) {
                            deferred.resolve();
                        }
                        else {
                            deferred.reject('Error saving max calories per day');
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