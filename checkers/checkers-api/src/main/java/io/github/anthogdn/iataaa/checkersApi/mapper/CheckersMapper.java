package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersApi.entity.CheckersEntity;
import io.github.anthogdn.iataaa.checkersDomain.model.Checkers;
import io.github.anthogdn.iataaa.checkersDto.entity.TokenDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;

public class CheckersMapper {

    private CheckersMapper() {
    }

    public static CreatedCheckersReadDto checkersEntityToCreatedCheckersReadDto(CheckersEntity checkersEntity) {
        TokenDto tokenDto = new TokenDto();
        tokenDto.setKey(checkersEntity.getPlayer().getToken());

        CheckersReadDto checkersReadDto = new CheckersReadDto();
        checkersReadDto.setId(checkersEntity.getId());
        checkersReadDto.setBoard(CheckersBoardMapper.stringToCheckersBoardDto(checkersEntity.getBoard()));
        checkersReadDto.setName(checkersEntity.getName());
        checkersReadDto.setPlayer(PlayerMapper.playerEntityToPlayerReadDto(checkersEntity.getPlayer()));
        checkersReadDto.setTurnPlayer(PlayerNbMapper.playerNbEntityToPlayerNbDto(checkersEntity.getTurnPlayer()));
        checkersReadDto.setWinner(PlayerNbMapper.playerNbEntityToPlayerNbDto(checkersEntity.getWinner()));

        CreatedCheckersReadDto createdCheckersReadDto = new CreatedCheckersReadDto();

        createdCheckersReadDto.setToken(tokenDto);
        createdCheckersReadDto.setCheckersGame(checkersReadDto);
        return createdCheckersReadDto;
    }

    public static CheckersEntity checkersToCheckersEntity(Checkers checkers) {
        CheckersEntity checkersEntity = new CheckersEntity();

        checkersEntity.setBoard(CheckersBoardMapper.checkersBoardToString(checkers.getCheckersBoard()));
        checkersEntity.setTurnPlayer(PlayerNbMapper.playerNbToPlayerNbEntity(checkers.getTurnPlayer()));
        checkersEntity.setWinner(PlayerNbMapper.playerNbToPlayerNbEntity(checkers.getWinner()));

        return checkersEntity;
    }
}
