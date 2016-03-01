requirejs(['../commonConfig'], function (commonConfig) {
    requirejs.config({
        paths:{
            usersApp:'./usersApp',
            usersServices:'./usersServices',
            usersControllers: './usersControllers'
        },
        shim: {
            usersApp: {
                deps: ['common', 'angularRoute', 'usersControllers']
            },
            usersServices: {
                deps: ['angular', 'csrfInterceptor']
            },
            usersControllers: {
                deps: ['usersServices']
            }
        }
    });

    requirejs(['adminLte', 'usersApp'], function(adminLte, userApp){
        console.log('starting usersApp angular');
        angular.bootstrap(document.getElementById('usersApp'), ['usersApp']);
    });

});