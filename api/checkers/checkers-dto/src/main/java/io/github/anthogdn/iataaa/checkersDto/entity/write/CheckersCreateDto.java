package io.github.anthogdn.iataaa.checkersDto.entity.write;

import io.github.anthogdn.iataaa.checkersDto.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CheckersCreateDto implements Dto {
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @NotNull
    private PlayerCreateDto player;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PlayerCreateDto getPlayer() {
        return player;
    }
    public void setPlayer(PlayerCreateDto player) {
        this.player = player;
    }
}
