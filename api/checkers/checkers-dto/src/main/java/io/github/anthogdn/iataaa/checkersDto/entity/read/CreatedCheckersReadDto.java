package io.github.anthogdn.iataaa.checkersDto.entity.read;

import io.github.anthogdn.iataaa.checkersDto.Dto;
import io.github.anthogdn.iataaa.checkersDto.entity.TokenDto;

public class CreatedCheckersReadDto implements Dto {
    private CheckersReadDto checkersGame;
    private TokenDto token;

    public CheckersReadDto getCheckersGame() {
        return checkersGame;
    }
    public void setCheckersGame(CheckersReadDto checkersGame) {
        this.checkersGame = checkersGame;
    }

    public TokenDto getToken() {
        return token;
    }
    public void setToken(TokenDto token) {
        this.token = token;
    }
}
