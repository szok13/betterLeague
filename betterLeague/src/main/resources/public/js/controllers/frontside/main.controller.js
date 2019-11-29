'use strict';

angular.module('betterApp')
    .controller('MainFrontCtrl', function ($scope, Bet) {

    $scope.betDTO={};
    $scope.betDTO.status="ACTIVE";

        $scope.createBet = function(){
        Bet.createBet($scope.betDTO,
            function(result){
                alert("All good");
            },
            function(error){
              console.log(error);
              alert("Coś poszło nie tak");
            });
        }
    });