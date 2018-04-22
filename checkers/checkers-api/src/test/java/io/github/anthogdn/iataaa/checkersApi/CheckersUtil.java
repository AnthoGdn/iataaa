package io.github.anthogdn.iataaa.checkersApi;

import io.github.anthogdn.iataaa.checkersApi.entity.CheckersEntity;
import io.github.anthogdn.iataaa.checkersApi.entity.PlayerNbEntity;
import io.github.anthogdn.iataaa.checkersApi.mapper.CheckersBoardMapper;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import io.github.anthogdn.iataaa.checkersDto.entity.TokenDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersMoveWriteDto;

import java.util.UUID;

import static io.github.anthogdn.iataaa.checkersApi.CheckersBoardUtil.INITIAL_CHECKERS_BOARD_STRING;

public class CheckersUtil {

    private CheckersUtil() {
    }

    public static CheckersMoveWriteDto getInitialCheckersMoveWriteDto(String token, String moveString) {
        TokenDto tokenDto = new TokenDto();
        tokenDto.setKey(token);

        CheckersMoveWriteDto checkersMoveWriteDto = new CheckersMoveWriteDto();
        checkersMoveWriteDto.setToken(tokenDto);

        CheckersBoard moveBoard = CheckersBoard.stringToCheckersBoard(moveString);
        CheckersBoardDto move = CheckersBoardMapper.stringToCheckersBoardDto(CheckersBoardMapper.checkersBoardToString(moveBoard));
        checkersMoveWriteDto.setMove(move);

        return checkersMoveWriteDto;
    }

    public static CheckersEntity getInitialCheckersEntity(
            UUID id, String name, String playerToken, String playerName, PlayerNbEntity playerNbEntity
    ) {
        CheckersEntity checkersEntity = new CheckersEntity();
        checkersEntity.setId(id);
        checkersEntity.setName(name);
        checkersEntity.setBoard(INITIAL_CHECKERS_BOARD_STRING);
        checkersEntity.setTurnPlayer(PlayerNbEntity.PLAYER_1);
        checkersEntity.setWinner(null);
        checkersEntity.setPlayer(PlayerUtil.getPlayer(playerToken, playerName, playerNbEntity));

        return checkersEntity;
    }
}
