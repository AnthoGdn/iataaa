package io.github.anthogdn.iataaa.checkersDto.entity.write;

import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;

import javax.validation.constraints.NotNull;

public class CheckersPossibleMovesRequestDto {
    @NotNull
    private CheckersBoardDto board;
    @NotNull
    private PlayerNbDto turnPlayer;

    public CheckersBoardDto getBoard() {
        return board;
    }
    public void setBoard(CheckersBoardDto board) {
        this.board = board;
    }

    public PlayerNbDto getTurnPlayer() {
        return turnPlayer;
    }
    public void setTurnPlayer(PlayerNbDto turnPlayer) {
        this.turnPlayer = turnPlayer;
    }
}
