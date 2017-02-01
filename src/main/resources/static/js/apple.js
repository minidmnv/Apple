angular.module('apple', [ 'ngRoute' ])
    .config(function ($routeProvider, $httpProvider) {
        $routeProvider.when('/', {
            templateUrl : 'fixtures.html',
            controller : 'fixtures'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";
    }).controller('fixtures', function ($scope, $http) {
        getFixtures();

        function getFixtures() {
            $http.get('/fixtures/limit=' + $scope.limit).then(function (success) {
                $scope.fixtures = success.data;
            });
        }
    })
    .controller('home', function($scope, $http) {

        $http.get('/resource').then(function (success) {
            $scope.greeting = success.data;
        });

    });