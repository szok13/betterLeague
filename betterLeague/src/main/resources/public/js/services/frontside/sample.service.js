'use strict';

angular.module('betterApp')
    .factory('Bet', function ($resource) {
        return $resource('api/bet', {}, {
            'createBet' : {
                method : 'POST'
            },
            'getAvailableGames' : {
                method :'GET',
                isArray : true
            },
            'getGameTeams' : {
                url: 'api/bet/getGameTeams/:gameId',
                gameId: '@gameId',
                method :'GET'
            }
        });
    });