package io.github.anthogdn.iataaa.checkersApi.service.impl;

import io.github.anthogdn.iataaa.checkersApi.CheckersUtil;
import io.github.anthogdn.iataaa.checkersApi.entity.CheckersEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerNbEntity;
import io.github.anthogdn.iataaa.checkersApi.exception.CodeException;
import io.github.anthogdn.iataaa.checkersApi.exception.NotAuthorizedException;
import io.github.anthogdn.iataaa.checkersApi.repository.CheckersRepository;
import io.github.anthogdn.iataaa.checkersApi.repository.PlayerRepository;
import io.github.anthogdn.iataaa.checkersApi.service.CheckersEntityService;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersCreateDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersMoveWriteDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.PlayerCreateDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.UUID;

import static io.github.anthogdn.iataaa.checkersApi.CheckersBoardUtil.getInitialCheckersBoardDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class CheckersEntityServiceImplTest {

    private CheckersEntityService checkersEntityService;
    private CheckersRepository checkersRepository;
    private PlayerRepository playerRepository;

    @Before
    public void setUp() {
        checkersRepository = mock(CheckersRepository.class);
        playerRepository = mock(PlayerRepository.class);
        checkersEntityService = new CheckersEntityServiceImpl(checkersRepository, playerRepository);
    }

    @Test
    public void createTest() {
        // GIVEN
        String playerName = "Ivana";
        CheckersCreateDto checkersCreateDto = new CheckersCreateDto();
        checkersCreateDto.setName("game");
        PlayerCreateDto player = new PlayerCreateDto();
        player.setName(playerName);
        checkersCreateDto.setPlayer(player);

        // WHEN
        when(playerRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);
        when(checkersRepository.save(any())).thenAnswer(i -> i.getArguments()[0]);
        CreatedCheckersReadDto createdCheckersReadDto = checkersEntityService.create(checkersCreateDto);

        // THEN
        assertThat(createdCheckersReadDto).isNotNull();
        assertThat(createdCheckersReadDto.getToken()).isNotNull();
        assertThat(createdCheckersReadDto.getCheckersGame()).isNotNull();
        assertThat(createdCheckersReadDto.getCheckersGame().getName()).isEqualTo("game");
        assertThat(createdCheckersReadDto.getCheckersGame().getBoard()).isEqualTo(getInitialCheckersBoardDto());
        assertThat(createdCheckersReadDto.getCheckersGame().getPlayer().getName()).isEqualTo(playerName);
        assertThat(createdCheckersReadDto.getCheckersGame().getPlayer().getPlayerNbDto()).isEqualTo(PlayerNbDto.PLAYER_1);
        assertThat(createdCheckersReadDto.getCheckersGame().getTurnPlayer()).isEqualTo(PlayerNbDto.PLAYER_1);
        assertThat(createdCheckersReadDto.getCheckersGame().getWinner()).isNull();
    }


    @Test
    public void playTest() throws NotAuthorizedException {
        // GIVEN
        UUID checkersId = UUID.randomUUID();
        String checkersName = "checkers";
        String token = "token";
        String playerName = "playerName";
        String moveString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |   o   |       |   o   |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|   o   |       |   o   |       |   o   |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |   o   |       |   o   |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|   o   |       |   o   |       |   o   |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|   x   |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";

        CheckersMoveWriteDto move = CheckersUtil.getInitialCheckersMoveWriteDto(token, moveString);

        CheckersEntity initialCheckersEntity = CheckersUtil.getInitialCheckersEntity(
                checkersId, checkersName, token, playerName, PlayerNbEntity.PLAYER_1
        );

        // WHEN
        when(checkersRepository.findById(checkersId)).thenReturn(Optional.of(initialCheckersEntity));
        CheckersReadDto checkersReadDto = checkersEntityService.play(checkersId, move);

        // THEN
        assertThat(checkersReadDto).isNotNull();
        assertThat(checkersReadDto.getName()).isEqualTo(checkersName);
        assertThat(checkersReadDto.getId()).isNotNull();
        assertThat(checkersReadDto.getWinner()).isNull();
        assertThat(checkersReadDto.getPlayer().getName()).isEqualTo(playerName);
        assertThat(checkersReadDto.getPlayer().getPlayerNbDto()).isEqualTo(PlayerNbDto.PLAYER_1);
        assertThat(checkersReadDto.getTurnPlayer()).isEqualTo(PlayerNbDto.PLAYER_1);
        assertThat(checkersReadDto.getBoard()).isNotNull();
        assertThat(checkersReadDto.getBoard()).isNotEqualTo(move.getMove());

        verify(checkersRepository, times(2)).save(any());
    }

    @Test
    public void playTestShouldCatchExceptionBecauseTokenIsBad() {
        // GIVEN
        UUID checkersId = UUID.randomUUID();
        String checkersName = "checkers";
        String token = "token";
        String playerName = "playerName";
        String moveString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |   o   |       |   o   |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|   o   |       |   o   |       |   o   |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |   o   |       |   o   |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|   o   |       |   o   |       |   o   |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|   x   |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";

        CheckersMoveWriteDto move = CheckersUtil.getInitialCheckersMoveWriteDto(token, moveString);

        CheckersEntity initialCheckersEntity = CheckersUtil.getInitialCheckersEntity(
                checkersId, checkersName, "", playerName, PlayerNbEntity.PLAYER_1
        );

        // WHEN
        when(checkersRepository.findById(checkersId)).thenReturn(Optional.of(initialCheckersEntity));
        try {
            checkersEntityService.play(checkersId, move);
            assert false : "Move should be catch because token is bad";
        // THEN
        } catch (NotAuthorizedException exception) {
            assertThat(exception.getCode()).isEqualTo(CodeException.BAD_TOKEN);
        }
    }

    @Test
    public void playTestShouldCatchExceptionBecauseIsNotTurnPlayer() {
        // GIVEN
        UUID checkersId = UUID.randomUUID();
        String checkersName = "checkers";
        String token = "token";
        String playerName = "playerName";
        String moveString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |   o   |       |   o   |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|   o   |       |   o   |       |   o   |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |   o   |       |   o   |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|   o   |       |   o   |       |   o   |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|   x   |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";

        CheckersMoveWriteDto move = CheckersUtil.getInitialCheckersMoveWriteDto(token, moveString);

        CheckersEntity initialCheckersEntity = CheckersUtil.getInitialCheckersEntity(
                checkersId, checkersName, token, playerName, PlayerNbEntity.PLAYER_2
        );

        // WHEN
        when(checkersRepository.findById(checkersId)).thenReturn(Optional.of(initialCheckersEntity));
        try {
            checkersEntityService.play(checkersId, move);
            assert false : "Move should be catch because is not turn player";
        // THEN
        } catch (NotAuthorizedException exception) {
            assertThat(exception.getCode()).isEqualTo(CodeException.IS_NOT_TURN_PLAYER);
        }
    }

    @Test
    public void playTestShouldCatchExceptionBecauseBadMove() {
        // GIVEN
        UUID checkersId = UUID.randomUUID();
        String checkersName = "checkers";
        String token = "token";
        String playerName = "playerName";
        String moveString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|   x   |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";

        CheckersMoveWriteDto move = CheckersUtil.getInitialCheckersMoveWriteDto(token, moveString);

        CheckersEntity initialCheckersEntity = CheckersUtil.getInitialCheckersEntity(
                checkersId, checkersName, token, playerName, PlayerNbEntity.PLAYER_1
        );

        // WHEN
        when(checkersRepository.findById(checkersId)).thenReturn(Optional.of(initialCheckersEntity));
        try {
            checkersEntityService.play(checkersId, move);
            assert false : "Move should be catch because move is not validate";
        // THEN
        } catch (NotAuthorizedException exception) {
            assertThat(exception.getCode()).isEqualTo(CodeException.MOVE_IS_NOT_VALIDATE);
        }
    }
}
