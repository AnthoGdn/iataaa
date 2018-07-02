package io.github.anthogdn.iataaa.checkersDomain.model;

public class Checkers {
    private CheckersBoard checkersBoard;
    private PlayerNb turnPlayer;
    private PlayerNb winner;

    public Checkers(CheckersBoard checkersBoard, PlayerNb turnPlayer, PlayerNb winner) {
        this.checkersBoard = checkersBoard;
        this.turnPlayer = turnPlayer;
        this.winner = winner;
    }

    public CheckersBoard getCheckersBoard() {
        return checkersBoard;
    }
    public void setCheckersBoard(CheckersBoard checkersBoard) {
        this.checkersBoard = checkersBoard;
    }

    public PlayerNb getTurnPlayer() {
        return turnPlayer;
    }
    public void setTurnPlayer(PlayerNb turnPlayer) {
        this.turnPlayer = turnPlayer;
    }

    public PlayerNb getWinner() {
        return winner;
    }
    public void setWinner(PlayerNb winner) {
        this.winner = winner;
    }
}
