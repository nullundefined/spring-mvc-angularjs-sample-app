///////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Defines the javascript files that need to be loaded and their dependencies.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////

require.config({
    paths: {
        angular: '../../bower_components/angular/angular',
        angularMessages: '../../bower_components/angular-messages/angular-messages',
        csrfInterceptor: '../../bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
       /* lodash: "../../bower_components/lodash/dist/lodash",*/
        jquery: "../../bower_components/jquery/dist/jquery",
        editableTableWidgets: 'editable-table-widgets',
        common: 'common',
        loginApp: 'login'
    },
    shim: {
        jquery: {
            exports: "$"
        },
        angular: {
            exports: "angular"
        },
        csrfInterceptor: {
            deps: ['angular']
        },
        angularMessages: {
            deps: ['angular']
        },
        editableTableWidgets: {
            deps: ['angular', 'lodash']
        },
        common: {
          deps: ['angular', 'csrfInterceptor', 'angularMessages','editableTableWidgets']
        },
        loginApp: {
            deps: [ 'common']
        }
    }
});

require(['loginApp'], function ($) {
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });

    angular.bootstrap(document.getElementById('loginApp'), ['loginApp']);

});