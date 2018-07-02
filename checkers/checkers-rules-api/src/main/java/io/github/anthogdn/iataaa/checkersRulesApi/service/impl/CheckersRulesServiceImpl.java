package io.github.anthogdn.iataaa.checkersRulesApi.service.impl;

import io.github.anthogdn.iataaa.checkersDomain.model.Checkers;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDomain.model.Move;
import io.github.anthogdn.iataaa.checkersDomain.service.CheckersService;
import io.github.anthogdn.iataaa.checkersDomain.service.impl.CheckersServiceImpl;
import io.github.anthogdn.iataaa.checkersDomainDtoMapper.CheckersBoardMapper;
import io.github.anthogdn.iataaa.checkersDomainDtoMapper.MoveMapper;
import io.github.anthogdn.iataaa.checkersDomainDtoMapper.PlayerNbMapper;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersPossibleMovesResponseDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersPossibleMovesRequestDto;
import io.github.anthogdn.iataaa.checkersRulesApi.service.CheckersRulesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CheckersRulesServiceImpl implements CheckersRulesService {

    private CheckersService checkersService;

    public CheckersRulesServiceImpl() {
        checkersService = new CheckersServiceImpl();
    }

    @Override
    public CheckersPossibleMovesResponseDto getPossiblesChainMoves(CheckersPossibleMovesRequestDto requestDto) {
        CheckersBoard checkersBoard = CheckersBoardMapper.checkersBoardDtoToCheckersBoard(requestDto.getBoard());
        Checkers checkers = new Checkers(
                checkersBoard, PlayerNbMapper.playerNbDtoToPlayerNb(requestDto.getTurnPlayer()), null
        );
        Set<Move> moveSet = checkersService.getAvailableChainMoves(checkers);
        return MoveMapper.moveSetToCheckersPossibleMovesResponseDto(moveSet);
    }
}
