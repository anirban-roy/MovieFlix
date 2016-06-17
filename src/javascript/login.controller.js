/**
 * Created by Anirban Roy on 6/10/2016.
 */

/* controller to manage and validate user login */

(function(){
    angular.module('loginapp')
        .controller('LoginController', LoginController);

    LoginController.$inject=['$http', '$cookies', '$window'];

    function LoginController($http, $cookies, $window) {
        var loginVm = this;

        loginVm.user = {
            email: '',
            password: ''
        };
        loginVm.message='';
        loginVm.validateUser = validateUser;
        loginVm.loadSignup = loadSignup;

        function validateUser(){
            $http({
                method : "GET",
                url : "http://localhost:8080/MovieService/validateUser?loginid="+loginVm.user.email+"&passwd="+loginVm.user.password
            }).then(function success(response) {
                //$scope.myWelcome = response.data;
                if(response.data.user.valid == 'valid') {
                    // create a cookie to contain auth token for later user transactions validations
                    var userAuth = {
                        userid: response.data.user.userid,
                        authtoken: response.data.user.authtoken
                    }
                    $cookies.put('userAuthorization', userAuth);
                    // redirect to login home
                    $window.location.href = 'catalog.html';

                } else{
                    // show error message
                    loginVm.user = {
                        email: '',
                        password: ''
                    };
                    loginVm.message='Invalid username and/or password. Cannot proceed!';
                }
            }, function requestError(response) {
                loginVm.message='Error on server side. Try again later! Status:'+response.status+'('+response.statusText+')';
            });
        }
        
        function loadSignup() {
            $window.location.href = '#signup';
        }

    }
})();