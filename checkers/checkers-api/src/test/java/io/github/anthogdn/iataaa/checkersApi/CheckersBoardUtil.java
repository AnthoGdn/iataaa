package io.github.anthogdn.iataaa.checkersApi;

import io.github.anthogdn.iataaa.checkersDomain.model.Case;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDomain.service.CheckersService;
import io.github.anthogdn.iataaa.checkersDomain.service.impl.CheckersServiceImpl;
import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;
import io.github.anthogdn.iataaa.checkersDto.type.CaseDto;

public class CheckersBoardUtil {
    public static final String INITIAL_CHECKERS_BOARD_STRING = "xxxxxxxxxxxxxxxxxxxx          oooooooooooooooooooo";
    public static final String MIXED_CHECKERS_BOARD_STRING = "ooooooooooOOOOOOOOOOxxxxxxxxxxXXXXXXXXXX          ";

    private CheckersBoardUtil() {
    }

    public static CheckersBoard getInitialCheckersBoard() {
        CheckersService checkersService = new CheckersServiceImpl();
        return checkersService.getInitializedCheckers().getCheckersBoard();
    }

    public static CheckersBoard getMixedCheckersBoard() {
        Case[] cases = new Case[50];
        for (int i = 0; i < 10; ++i) cases[i] = Case.BLACK_PIECE;
        for (int i = 10; i < 20; ++i) cases[i] = Case.BLACK_QUEEN;
        for (int i = 20; i < 30; ++i) cases[i] = Case.WHITE_PIECE;
        for (int i = 30; i < 40; ++i) cases[i] = Case.WHITE_QUEEN;
        for (int i = 40; i < 50; ++i) cases[i] = Case.EMPTY;

        return new CheckersBoard(cases);
    }

    public static CheckersBoardDto getInitialCheckersBoardDto() {
        CaseDto[] caseDtos = new CaseDto[50];
        for (int i = 0; i < 20; ++i) caseDtos[i] = CaseDto.WHITE_PIECE;
        for (int i = 20; i < 30; ++i) caseDtos[i] = CaseDto.EMPTY;
        for (int i = 30; i < 50; ++i) caseDtos[i] = CaseDto.BLACK_PIECE;

        CheckersBoardDto checkersBoardDto = new CheckersBoardDto();
        checkersBoardDto.setCases(caseDtos);
        return checkersBoardDto;
    }

    public static CheckersBoardDto getMixedCheckersBoardDto() {
        CaseDto[] caseDtos = new CaseDto[50];
        for (int i = 0; i < 10; ++i) caseDtos[i] = CaseDto.BLACK_PIECE;
        for (int i = 10; i < 20; ++i) caseDtos[i] = CaseDto.BLACK_QUEEN;
        for (int i = 20; i < 30; ++i) caseDtos[i] = CaseDto.WHITE_PIECE;
        for (int i = 30; i < 40; ++i) caseDtos[i] = CaseDto.WHITE_QUEEN;
        for (int i = 40; i < 50; ++i) caseDtos[i] = CaseDto.EMPTY;

        CheckersBoardDto checkersBoardDto = new CheckersBoardDto();
        checkersBoardDto.setCases(caseDtos);
        return checkersBoardDto;
    }
}
