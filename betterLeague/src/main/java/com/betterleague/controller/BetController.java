package com.betterleague.controller;


import com.betterleague.controller.DTO.BetDTO;
import com.betterleague.domain.Bet;
import com.betterleague.domain.User;
import com.betterleague.domain.enumeration.BetStatus;
import com.betterleague.repository.BetRepository;
import com.betterleague.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class BetController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BetRepository betRepository;

    protected final Logger logger = Logger.getLogger(getClass().getName());

    @RequestMapping(value = "/bet",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createBet(@RequestBody BetDTO betDTO)  {
        logger.log(Level.INFO,"In createBet method.");
        Bet bet = new Bet();
        bet.setStatus(BetStatus.ACTIVE);

        //Optional<User> user = userRepository.findOneByLogin(betDTO.getPlayerLogin());
        //bet.setPlayer(user.get());
        User user = userRepository.save(new User(betDTO.getPlayerLogin(), betDTO.getPlayerLogin(), betDTO.getPlayerLogin()));
        bet.setPlayer(user);
        betRepository.save(bet);

        return new ResponseEntity<>(betRepository.save(bet), HttpStatus.CREATED);
    }
}
