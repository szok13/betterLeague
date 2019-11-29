package com.betterleague.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="creation_time", nullable = false)
    private Date creationTime = new Date();

    @Column(name="game_time")
    private Date plannedGameStartTime = new Date();

    @Column(name="team_one_name")
    private String teamOneName;

    @Column(name="team_two_name")
    private String teamTwoName;

    @OneToOne
    @JoinColumn(name="game_result_id")
    private GameResult gameResult;
}
