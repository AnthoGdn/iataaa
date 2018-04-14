package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersApi.CheckersBoardUtil;
import io.github.anthogdn.iataaa.checkersApi.entity.CheckersEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerNbEntity;
import io.github.anthogdn.iataaa.checkersDomain.model.Checkers;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.junit.Test;

import java.util.UUID;

import static io.github.anthogdn.iataaa.checkersApi.CheckersBoardUtil.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CheckersMapperTest {

    @Test
    public void checkersToCreatedCheckersReadDtoTest() {
        // GIVEN
        String checkersName = "game";
        String playerName = "ivana";
        UUID checkerId = UUID.randomUUID();
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setPlayerNb(PlayerNbMapper.playerNbDtoToPlayerNbEntity(PlayerNbDto.PLAYER_2));
        playerEntity.setName(playerName);

        CheckersEntity checkersEntity = new CheckersEntity();
        checkersEntity.setId(checkerId);
        checkersEntity.setBoard(MIXED_CHECKERS_BOARD_STRING);
        checkersEntity.setName(checkersName);
        checkersEntity.setPlayer(playerEntity);
        checkersEntity.setTurnPlayer(PlayerNbMapper.playerNbDtoToPlayerNbEntity(PlayerNbDto.PLAYER_2));
        checkersEntity.setWinner(PlayerNbMapper.playerNbDtoToPlayerNbEntity(PlayerNbDto.PLAYER_1));

        // WHEN
        CreatedCheckersReadDto createdCheckersReadDto = CheckersMapper.checkersEntityToCreatedCheckersReadDto(checkersEntity);

        // THEN
        assertThat(createdCheckersReadDto).isNotNull();
        assertThat(createdCheckersReadDto.getToken()).isNotNull();
        assertThat(createdCheckersReadDto.getCheckersGame()).isNotNull();
        assertThat(createdCheckersReadDto.getCheckersGame().getId()).isEqualTo(checkerId);
        assertThat(createdCheckersReadDto.getCheckersGame().getBoard()).isEqualTo(getMixedCheckersBoardDto());
        assertThat(createdCheckersReadDto.getCheckersGame().getName()).isEqualTo(checkersName);
        assertThat(createdCheckersReadDto.getCheckersGame().getPlayer().getPlayerNbDto()).isEqualTo(PlayerNbDto.PLAYER_2);
        assertThat(createdCheckersReadDto.getCheckersGame().getPlayer().getName()).isEqualTo(playerName);
        assertThat(createdCheckersReadDto.getCheckersGame().getTurnPlayer()).isEqualTo(PlayerNbDto.PLAYER_2);
        assertThat(createdCheckersReadDto.getCheckersGame().getWinner()).isEqualTo(PlayerNbDto.PLAYER_1);
    }

    @Test
    public void checkersToCheckersEntityTest() {
        // GIVEN
        CheckersBoard checkersBoard = CheckersBoardUtil.getInitialCheckersBoard();
        Checkers checkers = new Checkers(checkersBoard, PlayerNb.PLAYER_1, PlayerNb.PLAYER_2);

        // WHEN
        CheckersEntity checkersEntity = CheckersMapper.checkersToCheckersEntity(checkers);

        // THEN
        assertThat(checkersEntity).isNotNull();
        assertThat(checkersEntity.getBoard()).isNotNull();
        assertThat(checkersEntity.getTurnPlayer()).isNotNull();
        assertThat(checkersEntity.getWinner()).isNotNull();

        assertThat(checkersEntity.getBoard()).isEqualTo(INITIAL_CHECKERS_BOARD_STRING);
        assertThat(checkersEntity.getTurnPlayer()).isEqualTo(PlayerNbEntity.PLAYER_1);
        assertThat(checkersEntity.getWinner()).isEqualTo(PlayerNbEntity.PLAYER_2);
    }
}
