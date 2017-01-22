angular.module('apple', [])
    .controller('home', function($scope, $http) {

        $http.get('/resource').then(function (success) {
            $scope.greeting = success.data;
        });

    });