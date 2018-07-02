package io.github.anthogdn.iataaa.checkersDto.entity.read;

import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CheckersReadDto extends AbstractEntityReadDto {
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @NotNull
    private CheckersBoardDto board;
    @NotNull
    private PlayerReadDto player;
    @NotNull
    private PlayerNbDto turnPlayer;
    private PlayerNbDto winner;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public CheckersBoardDto getBoard() {
        return board;
    }
    public void setBoard(CheckersBoardDto board) {
        this.board = board;
    }

    public PlayerReadDto getPlayer() {
        return player;
    }
    public void setPlayer(PlayerReadDto player) {
        this.player = player;
    }

    public PlayerNbDto getTurnPlayer() {
        return turnPlayer;
    }
    public void setTurnPlayer(PlayerNbDto turnPlayer) {
        this.turnPlayer = turnPlayer;
    }

    public PlayerNbDto getWinner() {
        return winner;
    }
    public void setWinner(PlayerNbDto winner) {
        this.winner = winner;
    }
}
