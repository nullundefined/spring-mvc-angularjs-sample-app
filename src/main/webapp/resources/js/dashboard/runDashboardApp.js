requirejs(['../commonConfig'], function (commonConfig) {
    requirejs.config({
        paths:{
            dashboardApp:'./dashboardApp'
        },
        shim: {
            dashboardApp: {
                deps: ['common', 'commonServices', 'angularRoute']
            }
        }
    });

    requirejs(['adminLte', 'dashboardApp'], function(adminLte, userApp){
        console.log('starting usersApp angular');
        console.log(adminLte)
        angular.bootstrap(document.getElementById('dashboardApp'), ['dashboardApp']);
    });

});