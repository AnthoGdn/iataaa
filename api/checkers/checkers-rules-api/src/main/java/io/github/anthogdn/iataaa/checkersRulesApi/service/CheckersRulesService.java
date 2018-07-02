package io.github.anthogdn.iataaa.checkersRulesApi.service;

import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersPossibleMovesResponseDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersPossibleMovesRequestDto;

public interface CheckersRulesService {
    CheckersPossibleMovesResponseDto getPossiblesChainMoves(CheckersPossibleMovesRequestDto requestDto);
}
