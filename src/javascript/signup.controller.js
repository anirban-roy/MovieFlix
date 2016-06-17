/**
 * Created by Anirban Roy on 6/16/2016.
 */


(function() {
    angular.module('loginapp')
        .controller('SignupController', SignupControllerFunc);

    SignupControllerFunc.$inject = ['$http', '$window'];

    function SignupControllerFunc($http, $window){
        var signupVm = this;

        signupVm.message = '';
        signupVm.user = {
            email: '',
            name:'',
            password1: '',
            password2:''
        };

        signupVm.registerUser = registerUser;
        signupVm.backToLogin = backToLogin;

        /* Register the user to the server DB */
        function registerUser(){
            $http({
                method : "POST",
                url : "http://localhost:8080/MovieService/registerNewUser",
                data: signupVm.user
            }).then(function success(response) {
                if(response.data.registered == true) {
                    signupVm.message = 'You have been successfully registered. Please login!';
                    //$window.location.href = '#';
                } else{
                    // show error message
                    signupVm.user = {
                        email: '',
                        name:'',
                        password1: '',
                        password2:''
                    };
                    signupVm.message='Failed to register user';
                }
            }, function myError(response) {
                signupVm.message='Error on server side. Try again later! Status:'+response.status+'('+response.statusText+')';
            });
            signupVm.message = 'You have been successfully registered. Please login!';
        }

        function backToLogin(){
            $window.location.href ="#"
        }
    }

})();