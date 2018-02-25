package io.github.anthogdn.iataaa.checkersApi.service.impl;

import io.github.anthogdn.iataaa.checkersApi.entity.CheckersEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerEntity;
import io.github.anthogdn.iataaa.checkersApi.mapper.CheckersMapper;
import io.github.anthogdn.iataaa.checkersApi.mapper.PlayerNbMapper;
import io.github.anthogdn.iataaa.checkersApi.exception.NotFoundException;
import io.github.anthogdn.iataaa.checkersApi.repository.CheckersRepository;
import io.github.anthogdn.iataaa.checkersApi.repository.PlayerRepository;
import io.github.anthogdn.iataaa.checkersApi.service.CheckersEntityService;
import io.github.anthogdn.iataaa.checkersDomain.model.Checkers;
import io.github.anthogdn.iataaa.checkersDomain.service.CheckersService;
import io.github.anthogdn.iataaa.checkersDomain.service.impl.CheckersServiceImpl;
import io.github.anthogdn.iataaa.checkersDto.entity.TokenDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersCreateDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersMoveWriteDto;
import io.github.anthogdn.iataaa.checkersDto.params.PageParams;
import io.github.anthogdn.iataaa.checkersDto.type.PlayerNbDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CheckersEntityServiceImpl implements CheckersEntityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckersEntityServiceImpl.class);

    private CheckersService checkersService;
    private CheckersRepository checkersRepository;
    private PlayerRepository playerRepository;

    public CheckersEntityServiceImpl(
            @Autowired CheckersRepository checkersRepository,
            @Autowired PlayerRepository playerRepository
    ) {
        super();
        checkersService = new CheckersServiceImpl();
        this.checkersRepository = checkersRepository;
        this.playerRepository = playerRepository;
    }

    public CreatedCheckersReadDto create(CheckersCreateDto checkersCreateDto) {
        Checkers initializedCheckers = checkersService.getInitializedCheckers();
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(checkersCreateDto.getPlayer().getName());
        playerEntity.setPlayerNb(PlayerNbMapper.playerNbDtoToPlayerNbEntity(PlayerNbDto.PLAYER_1));

        CheckersEntity checkersEntity = CheckersMapper.checkersToCheckersEntity(initializedCheckers);
        checkersEntity.setName(checkersCreateDto.getName());
        checkersEntity.setPlayer(playerEntity);

        playerRepository.save(checkersEntity.getPlayer());
        LOGGER.info("create player entity: {}", checkersEntity);
        checkersEntity = checkersRepository.save(checkersEntity);
        LOGGER.info("create checkers entity: {}", checkersEntity);
        return CheckersMapper.checkersEntityToCreatedCheckersReadDto(checkersEntity);
    }

    public Page<CheckersReadDto> getAll(PageParams pageParams) {
        return null;
    }

    public CheckersReadDto getById(String id) throws NotFoundException {
        return null;
    }

    public CheckersReadDto play(String id, CheckersMoveWriteDto move) {
        /*
        * J'utilise CheckersBoardService.
        * Je donne à la methode play les parametres : checkers board, le joueur qui doit jouer
        * Je recoit une liste de Checkers possibles
        * */
        return null;
    }

    public CheckersReadDto surrender(String id, TokenDto tokenDto) throws NotFoundException {
        return null;
    }
}
