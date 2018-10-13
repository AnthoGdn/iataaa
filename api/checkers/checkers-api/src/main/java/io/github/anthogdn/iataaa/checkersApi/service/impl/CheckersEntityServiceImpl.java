package io.github.anthogdn.iataaa.checkersApi.service.impl;

import io.github.anthogdn.iataaa.checkersApi.entity.CheckersEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerEntity;
import io.github.anthogdn.iataaa.checkersApi.exception.CodeException;
import io.github.anthogdn.iataaa.checkersApi.exception.NotAuthorizedException;
import io.github.anthogdn.iataaa.checkersApi.exception.NotFoundException;
import io.github.anthogdn.iataaa.checkersDomainDtoMapper.CheckersBoardMapper;
import io.github.anthogdn.iataaa.checkersApi.mapper.CheckersMapper;
import io.github.anthogdn.iataaa.checkersApi.mapper.CodeExceptionMapper;
import io.github.anthogdn.iataaa.checkersApi.mapper.PlayerNbMapper;
import io.github.anthogdn.iataaa.checkersApi.repository.CheckersRepository;
import io.github.anthogdn.iataaa.checkersApi.repository.PlayerRepository;
import io.github.anthogdn.iataaa.checkersApi.service.CheckersEntityService;
import io.github.anthogdn.iataaa.checkersDomain.model.Checkers;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;
import io.github.anthogdn.iataaa.checkersDomain.model.ValidityCheckersMoveException;
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
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CheckersEntityServiceImpl implements CheckersEntityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckersEntityServiceImpl.class);

    private final CheckersService checkersService;
    private final CheckersRepository checkersRepository;
    private final PlayerRepository playerRepository;

    public CheckersEntityServiceImpl(
            CheckersRepository checkersRepository,
            PlayerRepository playerRepository
    ) {
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
        LOGGER.info("Create player entity: {}", checkersEntity);
        checkersEntity = checkersRepository.save(checkersEntity);
        LOGGER.info("Create checkers entity: {}", checkersEntity);
        return CheckersMapper.checkersEntityToCreatedCheckersReadDto(checkersEntity);
    }

    public Page<CheckersReadDto> getAll(PageParams pageParams) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public CheckersReadDto getById(String id) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public CheckersReadDto play(
            String id, CheckersMoveWriteDto moveBoardDto
    ) throws NotAuthorizedException {
        CheckersEntity checkersEntity = playHuman(id, moveBoardDto);
        return playAi(checkersEntity);
    }

    public CheckersReadDto surrender(String id, TokenDto tokenDto) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet");
    }

    // PRIVATE

    private boolean isVerifiedPlayer(PlayerEntity player, String token) {
        return player.getToken().equals(token);
    }

    private CheckersReadDto playAi(CheckersEntity checkersEntity) {
        Checkers checkers = CheckersMapper.checkersEntityToCheckers(checkersEntity);
        try {
            checkers = checkersService.playAi(checkers, checkers.getTurnPlayer());
        } catch (ValidityCheckersMoveException ignored) {
        }

        CheckersEntity newCheckersEntity = mergeCheckers(checkersEntity, checkers);
        checkersRepository.save(newCheckersEntity);
        LOGGER.info("Create checkers entity: {}", newCheckersEntity);

        return CheckersMapper.checkersEntityToCheckersReadDto(newCheckersEntity);
    }

    private CheckersEntity playHuman(String id, CheckersMoveWriteDto moveBoardDto) throws NotAuthorizedException {
        CheckersEntity checkersEntity = checkersRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("CheckersEntity", id.toString(), "id"));

        if (!isVerifiedPlayer(checkersEntity.getPlayer(), moveBoardDto.getToken().getKey())) {
            throw new NotAuthorizedException("checkers id", id.toString(), CodeException.BAD_TOKEN);
        }

        Checkers checkers = CheckersMapper.checkersEntityToCheckers(checkersEntity);
        CheckersBoard moveBoard = CheckersBoardMapper.checkersBoardDtoToCheckersBoard(moveBoardDto.getMove());
        PlayerNb currentPlayerNb = PlayerNbMapper.playerNbEntityToPlayerNb(checkersEntity.getPlayer().getPlayerNb());

        try {
            checkers = checkersService.play(checkers, currentPlayerNb, moveBoard);
        } catch (ValidityCheckersMoveException exception) {
            throw new NotAuthorizedException(
                    "checkers id",
                    id.toString(),
                    CodeExceptionMapper.validityErrorsCheckersMoveToCodeException(exception.getError())
            );
        }

        checkersEntity = mergeCheckers(checkersEntity, checkers);
        checkersRepository.save(checkersEntity);
        LOGGER.info("Create checkers entity: {}", checkersEntity);

        return checkersEntity;
    }

    private CheckersEntity mergeCheckers(CheckersEntity checkersEntity, Checkers checkers) {
        CheckersEntity newCheckersEntity = new CheckersEntity();
        newCheckersEntity.setId(checkersEntity.getId());
        newCheckersEntity.setPlayer(checkersEntity.getPlayer());
        newCheckersEntity.setName(checkersEntity.getName());
        newCheckersEntity.setBoard(CheckersBoardMapper.checkersBoardToString(checkers.getCheckersBoard()));
        newCheckersEntity.setTurnPlayer(PlayerNbMapper.playerNbToPlayerNbEntity(checkers.getTurnPlayer()));
        newCheckersEntity.setWinner(PlayerNbMapper.playerNbToPlayerNbEntity(checkers.getWinner()));

        return newCheckersEntity;
    }
}
