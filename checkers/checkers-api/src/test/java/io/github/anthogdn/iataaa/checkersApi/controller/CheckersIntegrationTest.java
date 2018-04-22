package io.github.anthogdn.iataaa.checkersApi.controller;

import io.github.anthogdn.iataaa.checkersApi.entity.CheckersEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerNbEntity;
import io.github.anthogdn.iataaa.checkersApi.exception.NotAuthorizedException;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersCreateDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersMoveWriteDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.PlayerCreateDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.UUID;

import static io.github.anthogdn.iataaa.checkersApi.CheckersBoardUtil.INITIAL_CHECKERS_BOARD_STRING;
import static io.github.anthogdn.iataaa.checkersApi.CheckersUtil.getInitialCheckersMoveWriteDto;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CheckersIntegrationTest {

    @Autowired
    private CheckersController controller;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void createCheckersGoodParametersShouldReturnIsCreated() {
        // GIVEN
        String playerName = "player";
        String checkersName = "game";

        PlayerCreateDto player = new PlayerCreateDto();
        player.setName(playerName);
        CheckersCreateDto checkersCreateDto = new CheckersCreateDto();

        checkersCreateDto.setName(checkersName);
        checkersCreateDto.setPlayer(player);

        // WHEN
        CreatedCheckersReadDto createdCheckersReadDto = controller.create(checkersCreateDto);

        // THEN
        createdCheckersReadDtoIsValid(createdCheckersReadDto, checkersName, playerName);
        checkersEntityIsCorrectlyInitialized(getCheckersEntityByName(checkersName), checkersName, playerName);
    }

    @Test
    @Transactional
    public void playMove() throws NotAuthorizedException {
        // GIVEN

        UUID playerId = UUID.randomUUID();
        String playerName = "player";
        PlayerNbEntity playerNb = PlayerNbEntity.PLAYER_1;
        String token = "token";


        UUID checkersId = UUID.randomUUID();
        String board = INITIAL_CHECKERS_BOARD_STRING;
        String checkersName = "game";
        PlayerNbEntity turnPlayer = PlayerNbEntity.PLAYER_1;
        PlayerNbEntity winner = null;

        createCheckersInDB(
                playerId, playerName, playerNb, token,
                checkersId, board, checkersName, turnPlayer, winner
        );

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
        CheckersMoveWriteDto checkersMoveWriteDto = getInitialCheckersMoveWriteDto(token, moveString);

        // WHEN
        CheckersReadDto checkersReadDto = controller.play(checkersId, checkersMoveWriteDto);

        // THEN
        assertThat(checkersReadDto).isNotNull();
        assertThat(checkersReadDto.getName()).isEqualTo(checkersName);
        assertThat(checkersReadDto.getId()).isNotNull();
        assertThat(checkersReadDto.getWinner()).isNull();
        assertThat(checkersReadDto.getPlayer().getName()).isEqualTo(playerName);
        assertThat(checkersReadDto.getPlayer().getPlayerNbDto()).isEqualTo(PlayerNbDto.PLAYER_1);
        assertThat(checkersReadDto.getTurnPlayer()).isEqualTo(PlayerNbDto.PLAYER_1);
        assertThat(checkersReadDto.getBoard()).isNotNull();
        assertThat(checkersReadDto.getBoard()).isNotEqualTo(checkersMoveWriteDto.getMove());

        CheckersEntity checkersEntity = getCheckersEntityByName(checkersName);
        assertThat(checkersEntity.getBoard()).isNotNull();
        assertThat(checkersEntity.getBoard()).isNotEqualTo(INITIAL_CHECKERS_BOARD_STRING);
        assertThat(checkersEntity.getWinner()).isNull();
    }

    // PRIVATE

    private void createdCheckersReadDtoIsValid(
            CreatedCheckersReadDto createdCheckersReadDto,
            String checkersName,
            String playerName
    ) {
        assertThat(createdCheckersReadDto).isNotNull();
        assertThat(createdCheckersReadDto.getCheckersGame()).isNotNull();
        assertThat(createdCheckersReadDto.getCheckersGame().getId()).isNotNull();
        assertThat(createdCheckersReadDto.getCheckersGame().getPlayer()).isNotNull();
        assertThat(createdCheckersReadDto.getCheckersGame().getBoard()).isNotNull();
        assertThat(createdCheckersReadDto.getToken()).isNotNull();

        assertThat(createdCheckersReadDto.getCheckersGame().getPlayer().getName()).isEqualTo(playerName);
        assertThat(createdCheckersReadDto.getCheckersGame().getPlayer().getPlayerNbDto()).isEqualTo(PlayerNbDto.PLAYER_1);
        assertThat(createdCheckersReadDto.getCheckersGame().getName()).isEqualTo(checkersName);
        assertThat(createdCheckersReadDto.getCheckersGame().getTurnPlayer()).isEqualTo(PlayerNbDto.PLAYER_1);
        assertThat(createdCheckersReadDto.getCheckersGame().getWinner()).isNull();
    }

    private void checkersEntityIsCorrectlyInitialized(
            CheckersEntity checkersEntity,
            String checkersName,
            String playerName
    ) {
        assertThat(checkersEntity.getId()).isNotNull();
        assertThat(checkersEntity.getPlayer()).isNotNull();
        assertThat(checkersEntity.getWinner()).isNull();

        assertThat(checkersEntity.getName()).isEqualTo(checkersName);
        assertThat(checkersEntity.getBoard()).isEqualTo(INITIAL_CHECKERS_BOARD_STRING);
        assertThat(checkersEntity.getTurnPlayer()).isEqualTo(PlayerNbEntity.PLAYER_1);
        assertThat(checkersEntity.getPlayer().getName()).isEqualTo(playerName);
        assertThat(checkersEntity.getPlayer().getPlayerNb()).isEqualTo(PlayerNbEntity.PLAYER_1);
        assertThat(checkersEntity.getPlayer().getId()).isNotNull();
        assertThat(checkersEntity.getPlayer().getToken()).isNotNull();
    }

    private CheckersEntity getCheckersEntityByName(String checkersName) {
        return entityManager
                .createQuery("SELECT l FROM CheckersEntity l WHERE l.name = :name ", CheckersEntity.class)
                .setParameter("name", checkersName)
                .getSingleResult();
    }

    private CheckersEntity createCheckersInDB(
            UUID playerId, String playerName, PlayerNbEntity playerNb, String token,
            UUID checkersId, String board, String checkersName, PlayerNbEntity turnPlayer, PlayerNbEntity winner
    ) {
        PlayerEntity playerEntity = createPlayerInDb(playerId, playerName, playerNb, token);
        CheckersEntity checkersEntity = new CheckersEntity();
        checkersEntity.setId(checkersId);
        checkersEntity.setBoard(board);
        checkersEntity.setName(checkersName);
        checkersEntity.setTurnPlayer(turnPlayer);
        checkersEntity.setWinner(winner);
        checkersEntity.setPlayer(playerEntity);
        entityManager.persist(checkersEntity);

        return checkersEntity;
    }

    private PlayerEntity createPlayerInDb(UUID id, String name, PlayerNbEntity playerNb, String token) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(id);
        playerEntity.setName(name);
        playerEntity.setPlayerNb(playerNb);
        playerEntity.setToken(token);
        entityManager.persist(playerEntity);

        return playerEntity;
    }
}
