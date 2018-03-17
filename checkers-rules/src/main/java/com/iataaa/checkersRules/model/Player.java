package com.iataaa.checkersRules.model;

public enum Player {
    PLAYER_1, PLAYER_2;

    public static Player getNextPlayer(Player player) {
        if (player == null) throw new AssertionError();
        if (player == PLAYER_1) return PLAYER_2;
        return PLAYER_1;
    }
}
