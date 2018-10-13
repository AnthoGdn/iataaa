package io.github.anthogdn.iataaa.checkersDto.entity.write;

import io.github.anthogdn.iataaa.checkersDto.Dto;
import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import io.github.anthogdn.iataaa.checkersDto.entity.TokenDto;

import javax.validation.constraints.NotNull;


public class CheckersMoveWriteDto implements Dto {
    @NotNull
    private TokenDto token;
    @NotNull
    private CheckersBoardDto move;

    public TokenDto getToken() {
        return token;
    }
    public void setToken(TokenDto token) {
        this.token = token;
    }

    public CheckersBoardDto getMove() {
        return move;
    }
    public void setMove(CheckersBoardDto move) {
        this.move = move;
    }
}
