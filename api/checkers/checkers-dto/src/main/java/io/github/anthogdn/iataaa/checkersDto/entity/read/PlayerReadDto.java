package io.github.anthogdn.iataaa.checkersDto.entity.read;

import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlayerReadDto extends AbstractEntityReadDto {
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @NotNull
    private PlayerNbDto playerNbDto;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PlayerNbDto getPlayerNbDto() {
        return playerNbDto;
    }
    public void setPlayerNbDto(PlayerNbDto playerNbDto) {
        this.playerNbDto = playerNbDto;
    }
}
