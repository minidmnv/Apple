angular.module('apple', [ 'ngRoute' ])
    .config(function ($routeProvider, $httpProvider) {
        $routeProvider.when('/', {
            templateUrl : 'fixtures.html',
            controller : 'fixtures'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = "XMLHttpRequest";
    }).controller('fixtures', function ($scope, $http, $location) {
        $scope.limit = 5;
        getFixtures($scope.limit);

        function getFixtures(limit) {
            $http.get('/fixtures/limit=' + limit)
                .then(function (success) {
                    $scope.fixtures = success.data;
                });
        };

        $scope.showFixture = function(fixtureId) {
            $location.path('/fixtures/' + fixtureId);
        }

        $scope.range = function(start, end) {
            var result = [];
            for(var i = start; i <= end; i++) {
                result.push(i);
            }
            return result;
        };
    }).controller('home', function($scope, $http) {

        $http.get('/resource').then(function (success) {
            $scope.greeting = success.data;
        });

    }).filter('iif', function() {
        return function(input, trueValue, falseValue) {
            return input ? trueValue : falseValue;
        };
    })
    ;