package io.github.anthogdn.iataaa.checkersApi.entity;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@javax.persistence.Entity
public class CheckersEntity extends AbstractEntity {
    @NotNull
    @Size(min=1)
    private String name;
    @NotNull
    @Size(min = 50, max = 50)
    private String board;
    @NotNull
    @ManyToOne
    private PlayerEntity player;
    @NotNull
    private PlayerNbEntity turnPlayer;
    private PlayerNbEntity winner;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getBoard() {
        return board;
    }
    public void setBoard(String board) {
        this.board = board;
    }

    public PlayerEntity getPlayer() {
        return player;
    }
    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public PlayerNbEntity getTurnPlayer() {
        return turnPlayer;
    }
    public void setTurnPlayer(PlayerNbEntity turnPlayer) {
        this.turnPlayer = turnPlayer;
    }

    public PlayerNbEntity getWinner() {
        return winner;
    }
    public void setWinner(PlayerNbEntity winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "CheckersEntity{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", board='" + board + '\'' +
                ", player=" + player +
                ", turnPlayer=" + turnPlayer +
                ", winner=" + winner +
                '}';
    }
}
