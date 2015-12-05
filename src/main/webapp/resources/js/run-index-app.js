///////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Defines the javascript files that need to be loaded and their dependencies.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////

require.config({
    paths: {
        angular: '../bower_components/angular/angular',
        angularMessages: '../bower_components/angular-messages/angular-messages',
        csrfInterceptor: '../bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        common: 'common',
        indexApp: 'indexApp',
        bootstrap: '../bootstrap/js/bootstrap',
        slimscroll: '../bower_components/AdminLTE/plugins/slimScroll/jquery.slimscroll',
        <!-- FastClick -->
        fastclick: '../bower_components/AdminLTE/plugins/fastclick/fastclick',
        adminLte: '../bower_components/AdminLTE/dist/js/app',
        demo: '../bower_components/AdminLTE/dist/js/demo'
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
        common: {
            deps: ['angular', 'csrfInterceptor', 'angularMessages']
        },
        indexApp: {
            deps: ['common']
        },
        fastclick: {},
        adminLte: {},
        demo: {
            deps: ['adminLte']
        }

    }
});

require(['indexApp'], function () {
    /*$(function () {
     $('input').iCheck({
     checkboxClass: 'icheckbox_square-blue',
     radioClass: 'iradio_square-blue',
     increaseArea: '20%' // optional
     });
     });*/
    angular.bootstrap(document.getElementById('indexApp'), ['indexApp']);

});