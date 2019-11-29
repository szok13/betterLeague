package com.betterleague.domain;

import com.betterleague.domain.enumeration.BetStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="bet")
public class Bet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="creation_time", nullable = false)
    private Date creationTime = new Date();

    @ManyToOne
    @JoinColumn(name ="player_id")
    private User player;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private BetStatus status;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @OneToOne
    @JoinColumn(name="betted_game_result_id")
    private GameResult bettedGameResult;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public BetStatus getStatus() {
        return status;
    }

    public void setStatus(BetStatus status) {
        this.status = status;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameResult getBettedGameResult() {
        return bettedGameResult;
    }

    public void setBettedGameResult(GameResult bettedGameResult) {
        this.bettedGameResult = bettedGameResult;
    }
}
