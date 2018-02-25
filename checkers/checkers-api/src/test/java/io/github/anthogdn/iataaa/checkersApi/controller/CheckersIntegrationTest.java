package io.github.anthogdn.iataaa.checkersApi.controller;

import io.github.anthogdn.iataaa.checkersApi.entity.CheckersEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerNbEntity;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersCreateDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.PlayerCreateDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static io.github.anthogdn.iataaa.checkersApi.CheckersBoardUtil.INITIAL_CHECKERS_BOARD_STRING;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckersIntegrationTest {

    @Autowired
    private CheckersController controller;

    @PersistenceContext
    EntityManager entityManager;

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
        assertThat(checkersEntity.getId()).isNotEmpty();
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
}
