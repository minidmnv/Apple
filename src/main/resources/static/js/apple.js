angular.module('apple', [ 'ngRoute' ])
    .config(function ($routeProvider, $httpProvider) {
        $routeProvider.when('/', {
            templateUrl : 'fixtures.html',
            controller : 'fixturesCtrl'
        }).when('/fixture/:fixtureId', {
            templateUrl : 'fixture.html',
            controller : 'fixtureCtrl'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";
    }).controller('fixturesCtrl', function ($scope, $http, $location) {
        getFixtures();

        function getFixtures() {
            $http.get('/api/fixtures/')
                .then(function (success) {
                    $scope.fixtures = success.data;
                });
        };

        $scope.showFixture = function(fixtureId) {
            $location.path('/fixture/' + fixtureId);
        }

    }).controller('fixtureCtrl', function ($routeParams, $http, $scope) {

        $http.get('/api/fixtures/' + $routeParams.fixtureId)
            .then (function (success) {
                $scope.fixtureDetails = success.data;
        });

    }).filter('iif', function() {
        return function(input, trueValue, falseValue) {
            return input ? trueValue : falseValue;
        };
    });