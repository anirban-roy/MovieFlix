/**
 * Created by Anirban Roy on 6/15/2016.
 */


(function(){
    angular.module('catalogapp',['ngCookies'])
        .controller('CatalogController', CatalogController);

    CatalogController.$inject=['$http', '$cookies', '$window'];

    function CatalogController($http, $cookies, $q) {
        var catalogVm = this;
        catalogVm.movies = {
            values: ''
        };

        getMovies();

        //console.log(catalogVm.movies);

        // fetch all movies
        function getMovies() {
            var data = '';
            $http({
                method: "GET",
                url: "movielist.json"
            }).then(function success(response) {
                if (response.data === 'undefined' | response.data == null) {
                    // data is not fetched from movie service
                    catalogVm.message = 'Error: List of featured movies/series could not be fetched';
                } else {
                    // show error message
                    //console.log(data);
                    catalogVm.movies.values = response.data;
                    console.log('Data loaded..');
                }
            }, function myError(response) {
                catalogVm.message = 'Error on server side. Try again later! Status:' + response.status + '(' + response.statusText + ')';
            });
        }
    }
})();