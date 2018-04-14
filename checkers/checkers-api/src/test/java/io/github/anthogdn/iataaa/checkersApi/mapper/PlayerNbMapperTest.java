package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersApi.entity.PlayerNbEntity;
import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerNbMapperTest {

    @Test
    public void playerNbToPlayerNbDtoShouldReturnPLAYER_1Test() {
        // WHEN
        PlayerNbDto playerNbDtoDto = PlayerNbMapper.playerNbEntityToPlayerNbDto(PlayerNbEntity.PLAYER_1);

        // THEN
        assertThat(playerNbDtoDto).isEqualTo(PlayerNbDto.PLAYER_1);
    }

    @Test
    public void playerNbToPlayerNbDtoShouldReturnPLAYER_2Test() {
        // WHEN
        PlayerNbDto playerNbDtoDto = PlayerNbMapper.playerNbEntityToPlayerNbDto(PlayerNbEntity.PLAYER_2);

        // THEN
        assertThat(playerNbDtoDto).isEqualTo(PlayerNbDto.PLAYER_2);
    }

    @Test
    public void playerNbDtoToPlayerNbShouldReturnPLAYER_1Test() {
        // WHEN
        PlayerNbEntity playerNbEntityDto = PlayerNbMapper.playerNbDtoToPlayerNbEntity(PlayerNbDto.PLAYER_1);

        // THEN
        assertThat(playerNbEntityDto).isEqualTo(PlayerNbEntity.PLAYER_1);
    }

    @Test
    public void playerNbDtoToPlayerNbShouldReturnPLAYER_2Test() {
        // WHEN
        PlayerNbEntity playerNbEntityDto = PlayerNbMapper.playerNbDtoToPlayerNbEntity(PlayerNbDto.PLAYER_2);

        // THEN
        assertThat(playerNbEntityDto).isEqualTo(PlayerNbEntity.PLAYER_2);
    }

    @Test
    public void playerToPlayerNbEntityShouldReturnPLAYER_1Test() {
        // WHEN
        PlayerNbEntity playerNbEntityDto = PlayerNbMapper.playerNbToPlayerNbEntity(PlayerNb.PLAYER_1);

        // THEN
        assertThat(playerNbEntityDto).isEqualTo(PlayerNbEntity.PLAYER_1);
    }

    @Test
    public void playerToPlayerNbEntityShouldReturnPLAYER_2Test() {
        // WHEN
        PlayerNbEntity playerNbEntityDto = PlayerNbMapper.playerNbToPlayerNbEntity(PlayerNb.PLAYER_2);

        // THEN
        assertThat(playerNbEntityDto).isEqualTo(PlayerNbEntity.PLAYER_2);
    }
}
