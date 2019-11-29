package com.betterleague.domain;

import com.betterleague.domain.enumeration.Team;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="game_result")
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="winning_team", nullable = false)
    private Team winningTeam;

    @Column(name="winning_team_set_count")
    private Integer winningTeamSetCount;

    @Column(name="losing_team_set_count")
    private Integer losingTeamSetCount;

    @OneToMany
    @JoinColumn(name="id", referencedColumnName="id")
    private List<SetResult> setResults = new ArrayList<>();

    @Column(name="is_actual_result")
    private Boolean isActualResult;

    public Team getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(Team winningTeam) {
        this.winningTeam = winningTeam;
    }

    public Integer getWinningTeamSetCount() {
        return winningTeamSetCount;
    }

    public void setWinningTeamSetCount(Integer winningTeamSetCount) {
        this.winningTeamSetCount = winningTeamSetCount;
    }

    public Integer getLosingTeamSetCount() {
        return losingTeamSetCount;
    }

    public void setLosingTeamSetCount(Integer losingTeamSetCount) {
        this.losingTeamSetCount = losingTeamSetCount;
    }

    public List<SetResult> getSetResults() {
        return setResults;
    }

    public void setSetResults(List<SetResult> setResults) {
        this.setResults = setResults;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActualResult() {
        return isActualResult;
    }

    public void setActualResult(Boolean actualResult) {
        isActualResult = actualResult;
    }
}
