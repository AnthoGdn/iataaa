package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersApi.entity.PlayerEntity;
import io.github.anthogdn.iataaa.checkersDto.entity.read.PlayerReadDto;

public class PlayerMapper {

    private PlayerMapper() {
    }

    public static PlayerReadDto playerEntityToPlayerReadDto(PlayerEntity playerEntity) {
        PlayerReadDto playerReadDto = new PlayerReadDto();
        playerReadDto.setId(playerEntity.getId());
        playerReadDto.setName(playerEntity.getName());
        playerReadDto.setPlayerNbDto(PlayerNbMapper.playerNbEntityToPlayerNbDto(playerEntity.getPlayerNb()));
        return playerReadDto;
    }
}
