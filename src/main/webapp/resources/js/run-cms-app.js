///////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Defines the javascript files that need to be loaded and their dependencies.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////

require.config({
    paths: {
        angular: '../bower_components/angular/angular',
        angularMessages: '../bower_components/angular-messages/angular-messages',
        angularRoute: '../bower_components/angular-route/angular-route',
        csrfInterceptor: '../bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        main: 'main',
        controllers: 'controllers',
        frontendServices: 'frontend-services',
        bootstrap: '../bootstrap/js/bootstrap',
        slimscroll: '../bower_components/AdminLTE/plugins/slimScroll/jquery.slimscroll',
        <!-- FastClick -->
        fastclick: '../bower_components/AdminLTE/plugins/fastclick/fastclick',
        chartjs: '../bower_components/AdminLTE/plugins/chartjs/Chart',
        adminLte: '../bower_components/AdminLTE/dist/js/app',
        demo: '../bower_components/AdminLTE/dist/js/demo',
        jquery: '../bower_components/AdminLTE/plugins/jQuery/jQuery-2.1.4.min'
        /*<!-- AdminLTE App -->
         <script src="../../dist/js/app.min.js"></script>
         <!-- AdminLTE for demo purposes -->
         <script src="../../dist/js/demo.js"></script>*/

    },
    shim: {
        jquery: {
            exports: "$"
        },
        angular: {
            exports: "angular"
        },
        slimscroll: {
            deps: ['jquery']
        },
        bootstrap: {
            deps: ['jquery']
        },
        csrfInterceptor: {
            deps: ['angular']
        },
        angularMessages: {
            deps: ['angular']
        },
        angularRoute: {
            deps: ['angular']
        },
        common: {
            deps: ['angular', 'csrfInterceptor', 'angularMessages']
        },
        cmsApp: {
            deps: ['common', 'angularRoute', 'controllers']
        },
        frontendServices: {
            deps: ['angular', 'csrfInterceptor']
        },
        fastclick: {},
        chartjs: {
            deps: ['jquery']
        },
        adminLte: {
            deps: ['jquery', 'bootstrap', 'chartjs']
        },
        demo: {
            deps: ['adminLte']
        },
        controllers: {
            deps: ['frontendServices']
        }
    }
});

require(['cmsApp', 'adminLte'], function () {
    console.log('starting cmpsApp angular');
    /*$(function () {
     $('input').iCheck({
     checkboxClass: 'icheckbox_square-blue',
     radioClass: 'iradio_square-blue',
     increaseArea: '20%' // optional
     });
     });*/
    angular.bootstrap(document.getElementById('cmsApp'), ['cmsApp']);

});