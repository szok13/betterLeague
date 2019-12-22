'use strict';

angular.module('betterApp')
    .controller('MainFrontCtrl', function ($scope, Bet) {

        $scope.betDTO={};
        $scope.betDTO.status="ACTIVE";
        $scope.game={};

        $scope.gameList=[{
            gameId: "001", gameName: "Game no. 1"
        },  {
            gameId: "002", gameName: "Game no. 2"
        },  {
            gameId: "003", gameName: "Game no. 3"
        }];

      //  getAvailableGames();

        var getAvailableGames = function(){
            Bet.getAvailableGames({},
                function(result){
                $scope.gameList=[{
                    gameId: "001", gameName: "Game no. 1"
                },  {
                    gameId: "002", gameName: "Game no. 2"
                },  {
                    gameId: "003", gameName: "Game no. 3"
                }];
            },
                function(error){
                  console.log(error);
                  alert("Coś poszło nie tak");
                });
            }

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

        var getGameTeams = function(){
        Bet.getGameTeams({gameId: $scope.game.gameId},
            function(result){
                $scope.betDTO.gameId = $scope.game.gameId;
                $scope.teamOneName = result.teamOneName;
                $scope.teamTwoName = result.teamTwoName;
                $scope.showNow = true;
                $scope.teams = result;
                alert("All good");
            },
            function(error){
              console.log(error);
              alert("Coś poszło nie tak");
            });
        }

        $scope.updateGameChoice = function(){
          //  alert("All good Updated");
          getGameTeams();
        }


    });