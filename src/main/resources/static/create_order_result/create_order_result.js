angular.module('app').controller('createOrderResultController', function ($scope, $http, $location, orderIdStorage) {
    const contextPath = 'http://localhost:8189/market';

    fillPage = function () {
        $scope.orderId = orderIdStorage.getId();
        console.log(orderIdStorage.getId());
    };

    fillPage();
});