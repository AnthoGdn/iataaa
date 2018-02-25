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
                .mapToObj(c -> String.valueOf((char) c))
                .map(Case::stringToCase)
                .toArray(Case[]::new);
        return new CheckersBoard(cases);
    }

    public static CheckersBoardDto stringToCheckersBoardDto(String checkersBoardString) {
        CheckersBoardDto checkersBoardDto = new CheckersBoardDto();
        CaseDto[] caseDtos = checkersBoardString
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .map(CaseMapper::stringToCaseDto)
                .toArray(CaseDto[]::new);
        checkersBoardDto.setCases(caseDtos);

        return checkersBoardDto;
    }
}
