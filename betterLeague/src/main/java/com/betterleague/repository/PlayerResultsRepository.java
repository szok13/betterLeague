package com.betterleague.repository;

import com.betterleague.domain.PlayerResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface PlayerResultsRepository extends JpaRepository<PlayerResults,Long>, JpaSpecificationExecutor<PlayerResults> {

    Optional<PlayerResults> findOneByPlayer(Long Player);
}
