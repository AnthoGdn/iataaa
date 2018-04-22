package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersDomain.model.Case;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import io.github.anthogdn.iataaa.checkersDto.type.CaseDto;

import java.util.Arrays;

public class CheckersBoardMapper {

    private CheckersBoardMapper() {
    }

    public static String checkersBoardToString(CheckersBoard checkersBoard) {
        return Arrays.stream(checkersBoard.getCases())
                .map(Case::getRepresentation)
                .reduce(String::concat)
                .orElseThrow(() -> new IllegalArgumentException("Impossible to map checkers board to string"));
    }

    public static CheckersBoard stringToCheckersBoard(String checkersBoardString) {
        Case[] cases = checkersBoardString
                .chars()
                .mapToObj(caseChar -> String.valueOf((char) caseChar))
                .map(Case::stringToCase)
                .toArray(Case[]::new);
        return new CheckersBoard(cases);
    }

    public static CheckersBoardDto stringToCheckersBoardDto(String checkersBoardString) {
        CheckersBoardDto checkersBoardDto = new CheckersBoardDto();
        CaseDto[] caseDtos = checkersBoardString
                .chars()
                .mapToObj(caseChar -> String.valueOf((char) caseChar))
                .map(CaseDto::stringToCaseDto)
                .toArray(CaseDto[]::new);
        checkersBoardDto.setCases(caseDtos);

        return checkersBoardDto;
    }

    public static CheckersBoard checkersBoardDtoToCheckersBoard(CheckersBoardDto checkersBoardDto) {
        Case[] cases = Arrays.stream(checkersBoardDto.getCases())
                .map(CheckersBoardMapper::caseDtoToCase)
                .toArray(Case[]::new);
        return new CheckersBoard(cases);
    }

    private static Case caseDtoToCase(CaseDto caseDto) {
        switch (caseDto) {
            case EMPTY: return Case.EMPTY;
            case BLACK_PIECE: return Case.BLACK_PIECE;
            case BLACK_QUEEN: return Case.BLACK_QUEEN;
            case WHITE_PIECE: return Case.WHITE_PIECE;
            case WHITE_QUEEN: return Case.WHITE_QUEEN;
            default: throw new IllegalArgumentException();
        }
    }
}
