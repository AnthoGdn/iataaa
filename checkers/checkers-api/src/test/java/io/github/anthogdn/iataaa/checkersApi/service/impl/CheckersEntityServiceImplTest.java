package io.github.anthogdn.iataaa.checkersApi.service.impl;

import io.github.anthogdn.iataaa.checkersApi.repository.CheckersRepository;
import io.github.anthogdn.iataaa.checkersApi.repository.PlayerRepository;
import io.github.anthogdn.iataaa.checkersApi.service.CheckersEntityService;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersCreateDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.PlayerCreateDto;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.junit.Before;
import org.junit.Test;

import static io.github.anthogdn.iataaa.checkersApi.CheckersBoardUtil.getInitialCheckersBoardDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
}
