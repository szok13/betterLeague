package com.betterleague.controller.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BetDTO {

    @NotNull
    @Size(min = 1, max = 50)
    private String playerLogin;

    @Size(max = 50)
    private String status;

    @Size(max = 50)
    private String bettedWinner;

    private Integer winningTeamSetCount;

    private Integer losingTeamSetCount;
    //Create a separate DTO for array list of set points

    public String getPlayerLogin() {
        return playerLogin;
    }

    public String getStatus() {
        return status;
    }

    public String getBettedWinner() {
        return bettedWinner;
    }

    public Integer getWinningTeamSetCount() {
        return winningTeamSetCount;
    }

    public Integer getLosingTeamSetCount() {
        return losingTeamSetCount;
    }
}
