package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersApi.entity.PlayerEntity;
import io.github.anthogdn.iataaa.checkersDto.entity.read.PlayerReadDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayerMapperTest {

    @Test
    public void PlayerCreateDtoToPlayerTest() {
        // GIVEN
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName("playerEntity");
        playerEntity.setPlayerNb(PlayerNbMapper.playerNbDtoToPlayerNbEntity(PlayerNbDto.PLAYER_2));

        // WHEN
        PlayerReadDto playerReadDto = PlayerMapper.playerEntityToPlayerReadDto(playerEntity);

        // THEN
        assertThat(playerReadDto).isNotNull();
        assertThat(playerReadDto.getId().toString()).isEqualTo(playerEntity.getId());
        assertThat(playerReadDto.getName()).isEqualTo("playerEntity");
        assertThat(playerReadDto.getPlayerNbDto()).isEqualTo(PlayerNbDto.PLAYER_2);
    }
}
