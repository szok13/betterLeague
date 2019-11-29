package com.betterleague.domain;

import com.betterleague.domain.enumeration.Team;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="set_result")
public class SetResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="set_number")
    private Integer setNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="winning_team", nullable = false)
    private Team winningTeam;

    @Column(name="winning_team_set_points")
    private Integer winningTeamSetPoints;

    @Column(name="losing_team_set_points")
    private Integer lostTeamSetPoints;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(Integer setNumber) {
        this.setNumber = setNumber;
    }

    public Team getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(Team winningTeam) {
        this.winningTeam = winningTeam;
    }

    public Integer getWinningTeamSetPoints() {
        return winningTeamSetPoints;
    }

    public void setWinningTeamSetPoints(Integer winningTeamSetPoints) {
        this.winningTeamSetPoints = winningTeamSetPoints;
    }

    public Integer getLostTeamSetPoints() {
        return lostTeamSetPoints;
    }

    public void setLostTeamSetPoints(Integer lostTeamSetPoints) {
        this.lostTeamSetPoints = lostTeamSetPoints;
    }
}
