package com.telRan.tests.model;

public class Board {
    private String boardName;
    private String team;

    public Board setBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public Board setTeam(String team) {
        this.team = team;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getTeam() {
        return team;
    }
}
