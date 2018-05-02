package io.github.anthogdn.iataaa.checkersDomainDtoMapper;

import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerNbMapperTest {

    @Test
    public void playerNbDtoToPlayerNbShouldReturnPLAYER_1Test() {
        // WHEN
        PlayerNb playerNb = PlayerNbMapper.playerNbDtoToPlayerNb(PlayerNbDto.PLAYER_1);

        // THEN
        assertThat(playerNb).isEqualTo(PlayerNb.PLAYER_1);
    }

    @Test
    public void playerNbDtoToPlayerNbShouldReturnPLAYER_2Test() {
        // WHEN
        PlayerNb playerNb = PlayerNbMapper.playerNbDtoToPlayerNb(PlayerNbDto.PLAYER_2);

        // THEN
        assertThat(playerNb).isEqualTo(PlayerNb.PLAYER_2);
    }
}
