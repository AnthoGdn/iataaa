package io.github.anthogdn.iataaa.checkersDomainDtoMapper;

import io.github.anthogdn.iataaa.checkersDomain.model.Move;
import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersPossibleMovesResponseDto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MoveMapper {

    private static List<CheckersBoardDto> mapCasesListToCheckersBoardDTOList(Move move) {
        return move.getMove()
            .stream()
            .map(cases -> new CheckersBoardDto(CaseMapper.casesToCasesDTO(cases)))
            .collect(Collectors.toList());

    }

    public static CheckersPossibleMovesResponseDto moveSetToCheckersPossibleMovesResponseDto(Set<Move> moveSet) {
        CheckersPossibleMovesResponseDto checkersPossibleMovesResponseDto = new CheckersPossibleMovesResponseDto();

        Set<List<CheckersBoardDto>> set = moveSet
                .stream()
                .map(MoveMapper::mapCasesListToCheckersBoardDTOList)
                .distinct()
                .collect(Collectors.toSet());

        checkersPossibleMovesResponseDto.setPossibleMoves(set);
        return  checkersPossibleMovesResponseDto;
    }
}
