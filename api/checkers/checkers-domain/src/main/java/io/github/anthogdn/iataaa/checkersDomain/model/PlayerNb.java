package io.github.anthogdn.iataaa.checkersDomain.model;

public enum PlayerNb {
    PLAYER_1, PLAYER_2;

    public static PlayerNb getNextPlayer(PlayerNb playerNb) {
        if (playerNb == null) throw new AssertionError();
        if (playerNb == PLAYER_1) return PLAYER_2;
        return PLAYER_1;
    }
}
