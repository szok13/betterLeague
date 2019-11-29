'use strict';

angular.module('betterApp')
    .factory('Bet', function ($resource) {
        return $resource('api/bet', {}, {
            'createBet' : {
                method : 'POST'
            },
            'getBetList' : {
                method :'GET',
                isArray : true
            }
        });
    });