var commonServices = angular.module('commonServices', []);

commonServices.service('CsrfTokenService', [function () {
    var token = null;
    return {
        storeToken: function (p_token) {
            token = p_token;
        },
        getToken: function () {
            return token;
        }
    }
}]);