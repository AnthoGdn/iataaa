package com.iataaa.checkersRules.service.impl;

import com.iataaa.checkersRules.model.Case;
import com.iataaa.checkersRules.model.CheckersBoard;
import com.iataaa.checkersRules.model.EnumPlayer;
import com.iataaa.checkersRules.rules.CheckersRules;
import com.iataaa.checkersRules.service.CheckersRulesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CheckersRules.class)
public class CheckersRulesServiceImplTest {

    private CheckersRulesService checkersRulesService;

    @Before
    public void setUp() {
        checkersRulesService = new CheckersRulesServiceServiceImpl();
    }

    private CheckersBoard getBoard(Case... casesParam) {
        Case[] cases = new Case[50];
        for(int i = 0; i < 50; ++i) {
            if (i >= casesParam.length) {
                cases[i] = Case.EMPTY;
            } else {
                cases[i] = casesParam[i];
            }
        }
        return new CheckersBoard(cases);
    }

    @Test
    public void initializeCheckersBoardTest() {
        // GIVEN
        String expectedBoardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |   o   |       |   o   |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|   o   |       |   o   |       |   o   |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |   o   |       |   o   |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|   o   |       |   o   |       |   o   |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard expectedBoard = CheckersBoard.stringToCheckersBoard(expectedBoardString);

        // WHEN
        CheckersBoard result = checkersRulesService.getInitializedCheckersBoard();

        // THEN
        assertThat(result).isEqualTo(expectedBoard);
    }

    @Test
    public void isValidMoveShouldReturnTrue() {
        // GIVEN
        CheckersBoard board = getBoard(Case.BLACK_PIECE);
        CheckersBoard moveBoard = getBoard(Case.EMPTY, Case.BLACK_PIECE);
        CheckersBoard mockedBoardResult = getBoard(Case.EMPTY, Case.BLACK_PIECE);

        List<Case[]> mockedCases = new ArrayList<Case[]>() {{
            add(mockedBoardResult.getCases());
        }};

        mockStatic(CheckersRules.class);
        when(CheckersRules.getAvailableMoves(board.getCases(), EnumPlayer.PLAYER_1))
                .thenReturn(mockedCases);

        // WHERE
        boolean isValid = checkersRulesService.isValidMove(board, moveBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(isValid).isTrue();
    }

    @Test
    public void isValidateMoveShouldReturnFalse() {
        // GIVEN
        CheckersBoard board = getBoard(Case.BLACK_PIECE);
        CheckersBoard moveBoard = getBoard();
        CheckersBoard mockedBoardResult = getBoard(Case.EMPTY, Case.BLACK_PIECE);

        List<Case[]> mockedCases = new ArrayList<Case[]>() {{
            add(mockedBoardResult.getCases());
        }};

        mockStatic(CheckersRules.class);
        when(CheckersRules.getAvailableMoves(board.getCases(), EnumPlayer.PLAYER_1))
                .thenReturn(mockedCases);

        // WHERE
        boolean isValid = checkersRulesService.isValidMove(board, moveBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(isValid).isFalse();
    }

    @Test
    public void getAvailableMovesTest() {
        // GIVEN
        CheckersBoard board = getBoard(Case.BLACK_PIECE);
        CheckersBoard mockedBoardResult = getBoard(Case.EMPTY, Case.BLACK_PIECE);

        List<Case[]> mockedCases = new ArrayList<Case[]>() {{
                add(mockedBoardResult.getCases());
        }};

        mockStatic(CheckersRules.class);
        when(CheckersRules.getAvailableMoves(board.getCases(), EnumPlayer.PLAYER_1))
                .thenReturn(mockedCases);

        // WHERE
        List<CheckersBoard> result = checkersRulesService.getAvailableMoves(board, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(result).containsExactly(mockedBoardResult);
    }
}
