package io.github.anthogdn.iataaa.checkersDto.entity.write;

import io.github.anthogdn.iataaa.checkersDto.Dto;
import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import io.github.anthogdn.iataaa.checkersDto.entity.TokenDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;

import javax.validation.constraints.NotNull;


public class CheckersMoveWriteDto implements Dto {
    @NotNull
    private TokenDto token;
    @NotNull
    private CheckersBoardDto currentBoard;
    @NotNull
    private CheckersBoardDto move;
    @NotNull
    private PlayerNbDto currentPlayer;

    public TokenDto getToken() {
        return token;
    }
    public void setToken(TokenDto token) {
        this.token = token;
    }

    public CheckersBoardDto getCurrentBoard() {
        return currentBoard;
    }
    public void setCurrentBoard(CheckersBoardDto currentBoard) {
        this.currentBoard = currentBoard;
    }

    public CheckersBoardDto getMove() {
        return move;
    }
    public void setMove(CheckersBoardDto move) {
        this.move = move;
    }

    public PlayerNbDto getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(PlayerNbDto currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
