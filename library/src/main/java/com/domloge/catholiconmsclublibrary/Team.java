package com.domloge.catholiconmsclublibrary;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class Team {

    private int teamId;

    @NotBlank
    private String teamName;


    public Team() {
    }

    public Team(int teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
