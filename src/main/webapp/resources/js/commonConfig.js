requirejs.config({
    paths: {
        angular: '../../bower_components/angular/angular',
        angularMessages: '../../bower_components/angular-messages/angular-messages',
        angularRoute: '../../bower_components/angular-route/angular-route',
        csrfInterceptor: '../../bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        main: 'main',
        bootstrap: '../../bootstrap/js/bootstrap',
        slimscroll: '../../bower_components/AdminLTE/plugins/slimScroll/jquery.slimscroll',
        <!-- FastClick -->
        fastclick: '../../bower_components/AdminLTE/plugins/fastclick/fastclick',
        adminLte: '../../bower_components/AdminLTE/dist/js/app',
        demo: '../../bower_components/AdminLTE/dist/js/demo',
        jquery: '../../bower_components/AdminLTE/plugins/jQuery/jQuery-2.1.4.min',
        chartjs: '../../bower_components/AdminLTE/plugins/chartjs/Chart',
        common: '../common',
        commonServices: '../common/commonServices'
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
        commonServices:{
            deps: ['angular']
        }
    }
});