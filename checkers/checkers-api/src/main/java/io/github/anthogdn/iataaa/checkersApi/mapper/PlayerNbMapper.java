package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersApi.entity.PlayerNbEntity;
import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;

public class PlayerNbMapper {

    private PlayerNbMapper() {
    }

    public static PlayerNbDto playerNbEntityToPlayerNbDto(PlayerNbEntity playerNbEntity) {
        if (playerNbEntity == null) {
            return null;
        }
        switch (playerNbEntity) {
            case PLAYER_1: return PlayerNbDto.PLAYER_1;
            case PLAYER_2: return PlayerNbDto.PLAYER_2;
            default: throw new IllegalArgumentException();
        }
    }

    public static PlayerNbEntity playerNbDtoToPlayerNbEntity(PlayerNbDto playerNbDtoDto) {
        if (playerNbDtoDto == null) {
            return null;
        }
        switch (playerNbDtoDto) {
            case PLAYER_1: return PlayerNbEntity.PLAYER_1;
            case PLAYER_2: return PlayerNbEntity.PLAYER_2;
            default: throw new IllegalArgumentException();
        }
    }

    public static PlayerNbEntity playerNbToPlayerNbEntity(PlayerNb playerNb) {
        if (playerNb == null) {
            return null;
        }
        switch (playerNb) {
            case PLAYER_1: return PlayerNbEntity.PLAYER_1;
            case PLAYER_2: return PlayerNbEntity.PLAYER_2;
            default: throw new IllegalArgumentException();
        }
    }
}
