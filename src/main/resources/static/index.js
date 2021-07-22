angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http({
            url: 'http://localhost:8189/summer/products',
            method: 'GET',
            params: {}
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data;
        });
    };

    $scope.loadPage = function (pageIndex = 1) {
        $http({
            url: 'http://localhost:8189/summer/products_page',
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            console.log(response);
        });
    };

    $scope.counterValue = 1;

    $scope.clickIncrementButton = function () {
        $scope.counterValue += 1;
    };

    $scope.showProductInfo = function (productIndex) {
        $http({
            url: 'http://localhost:8189/summer/products/' + productIndex,
            method: 'GET'
        }).then(function (response) {
            alert(response.data.title);
        });
    };

    $scope.showProductInfoWithoutRequest = function (productIndex) {
        alert($scope.products[productIndex - 1].title);
    };

    $scope.loadProducts();

    $scope.deleteProduct = function (productIndex){
    $http({
                url: 'http://localhost:8189/summer/products/delete' + productIndex,
                method: 'GET'
            }).then(function (response) {
                alert("deleted");
            });
    }
});