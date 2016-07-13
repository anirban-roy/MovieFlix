/**
 * Created by Anirban Roy on 6/16/2016.
 */

(function() {
    angular.module('loginapp', ['ngCookies', 'ngRoute'])
        .config(loadConfig);

    function loadConfig($routeProvider){

        $routeProvider
            .when('/',{
                templateUrl: 'src/views/login_view.html',
                controller: 'LoginController',
                controllerAs: 'loginVm'
        })
            .when('/signup',{
                templateUrl: 'src/views/signup_view.html',
                controller: 'SignupController',
                controllerAs: 'signupVm'
            })
            .otherwise({
                redirectTo:'/'
            });
    }

})();