package com.betterleague.repository;

import com.betterleague.domain.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BetRepository extends JpaRepository<Bet,Long>, JpaSpecificationExecutor<Bet> {
        Optional<Bet> findOneById(Long id);
}