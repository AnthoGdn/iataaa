package com.iataaa.checkersRules.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

import static com.iataaa.checkersRules.model.CheckersBoard.PIECE_SIZE;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CheckersBoardTest {

    @Test
    public void convertInitialBoardStringToBoard() {
        // GIVEN
        Case[] cases = new Case[PIECE_SIZE];
        for(int i = 0; i < PIECE_SIZE; ++i) {
            if (i < 20) cases[i] = Case.WHITE_PIECE;
            if (i >= 20 && i < 30) cases[i] = Case.EMPTY;
            if (i >= 30) cases[i] = Case.BLACK_PIECE;
        }
        CheckersBoard expectedBoard = new CheckersBoard(cases);

        String boardString =
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
        // WHEN
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);

        // THEN
        assertThat(checkersboard).isEqualTo(expectedBoard);
    }

    @Test
    public void convertBoardStringToBoard() {
        // GIVEN
        Case[] cases = new Case[PIECE_SIZE];
        for(int i = 0; i < PIECE_SIZE; ++i) {
            if (i % 3 == 0) {
                cases[i] = Case.WHITE_PIECE;
            } else if (i % 3 == 1) {
                cases[i] = Case.BLACK_PIECE;
            } else {
                cases[i] = Case.EMPTY;
            }
        }
        CheckersBoard expectedBoard = new CheckersBoard(cases);

        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |   x   |       |   o   |       |       |       |   x   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|   o   |       |       |       |   x   |       |   o   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |   x   |       |   o   |       |       |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|   x   |       |   o   |       |       |       |   x   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |   o   |       |       |       |   x   |       |   o   |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |   x   |       |   o   |       |       |       |   x   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |   x   |       |   o   |       |       |       |   x   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|   o   |       |       |       |   x   |       |   o   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |   x   |       |   o   |       |       |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   x   |       |   o   |       |       |       |   x   |       |   o   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";

        // WHEN
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);

        // THEN
        assertThat(checkersboard).isEqualTo(expectedBoard);
    }

    @Test
    public void convertBoardStringWithQueenToBoard() {
        // GIVEN
        Case[] cases = new Case[PIECE_SIZE];
        for(int i = 0; i < PIECE_SIZE; ++i) {
            if (i % 3 == 0) {
                cases[i] = Case.BLACK_QUEEN;
            } else if (i % 3 == 1) {
                cases[i] = Case.WHITE_QUEEN;
            } else {
                cases[i] = Case.EMPTY;
            }
        }
        CheckersBoard expectedBoard = new CheckersBoard(cases);
        String boardString =
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "9|       |   O   |       |   X   |       |       |       |   O   |       |   X   |\n" +
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "8|   X   |       |       |       |   O   |       |   X   |       |       |       |\n" +
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "7|       |       |       |   O   |       |   X   |       |       |       |   O   |\n" +
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "6|   O   |       |   X   |       |       |       |   O   |       |   X   |       |\n" +
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "5|       |   X   |       |       |       |   O   |       |   X   |       |       |\n" +
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "4|       |       |   O   |       |   X   |       |       |       |   O   |       |\n" +
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "3|       |   O   |       |   X   |       |       |       |   O   |       |   X   |\n" +
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "2|   X   |       |       |       |   O   |       |   X   |       |       |       |\n" +
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "1|       |       |       |   O   |       |   X   |       |       |       |   O   |\n" +
                " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
                "0|   O   |       |   X   |       |       |       |   O   |       |   X   |       |\n" +
                " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";

        // WHEN
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);

        // THEN
        assertThat(checkersboard).isEqualTo(expectedBoard);
    }

    @Test
    public void validateReturnIsValid() {
        // GIVEN
        Case[] cases = new Case[PIECE_SIZE];
        for(int i = 0; i < PIECE_SIZE; ++i) {
            cases[i] = Case.EMPTY;
        }
        ValidityCheckersBoard expect = new ValidityCheckersBoard();

        // WHEN
        ValidityCheckersBoard validity = CheckersBoard.validate(cases);

        // THEN
        assertThat(validity).isEqualTo(expect);
    }

    @Test
    public void validateReturnIsNotValidBecauseCasesIsNull() {
        // GIVEN
        Set<ValidityErrorCheckersBoard> expectErrors = EnumSet.allOf(ValidityErrorCheckersBoard.class);
        expectErrors.addAll(
                Arrays.asList(ValidityErrorCheckersBoard.values())
        );
        ValidityCheckersBoard expect = new ValidityCheckersBoard(expectErrors);

        // WHEN
        ValidityCheckersBoard validity = CheckersBoard.validate(null);

        // THEN
        assertThat(validity).isEqualTo(expect);
    }

    @Test
    public void validateReturnIsNotValidBecauseCasesLengthIsNotEqual50() {
        // GIVEN
        Case[] cases = new Case[49];
        for(int i = 0; i < 49; ++i) {
            cases[i] = Case.EMPTY;
        }
        Set<ValidityErrorCheckersBoard> expectErrors = EnumSet.noneOf(ValidityErrorCheckersBoard.class);
        expectErrors.add(ValidityErrorCheckersBoard.CASES_ARRAY_LENGTH_NOT_EQUAL_50);
        ValidityCheckersBoard expect = new ValidityCheckersBoard(expectErrors);

        // WHEN
        ValidityCheckersBoard validity = CheckersBoard.validate(cases);

        // THEN
        assertThat(validity).isEqualTo(expect);
    }

    @Test
    public void validateReturnIsNotValidBecauseCasesContainsNull() {
        // GIVEN
        Case[] cases = new Case[PIECE_SIZE];
        for(int i = 0; i < PIECE_SIZE; ++i) {
            cases[i] = Case.EMPTY;
        }
        cases[40] = null;

        Set<ValidityErrorCheckersBoard> expectErrors = EnumSet.noneOf(ValidityErrorCheckersBoard.class);
        expectErrors.add(ValidityErrorCheckersBoard.CASES_ARRAY_CONTAINS_NULL);
        ValidityCheckersBoard expect = new ValidityCheckersBoard(expectErrors);

        // WHEN
        ValidityCheckersBoard validity = CheckersBoard.validate(cases);

        // THEN
        assertThat(validity).isEqualTo(expect);
    }

    @Test
    public void validateReturnIsNotValidBecauseCasesLengthIsNotEqual50AndCasesContainsNull() {
        // GIVEN
        Case[] cases = new Case[49];
        for(int i = 0; i < 49; ++i) {
            cases[i] = Case.EMPTY;
        }
        cases[40] = null;
        Set<ValidityErrorCheckersBoard> expectErrors = EnumSet.noneOf(ValidityErrorCheckersBoard.class);
        expectErrors.addAll(
                Arrays.asList(
                        ValidityErrorCheckersBoard.CASES_ARRAY_LENGTH_NOT_EQUAL_50,
                        ValidityErrorCheckersBoard.CASES_ARRAY_CONTAINS_NULL
                )
        );
        ValidityCheckersBoard expect = new ValidityCheckersBoard(expectErrors);

        // WHEN
        ValidityCheckersBoard validity = CheckersBoard.validate(cases);

        // THEN
        assertThat(validity).isEqualTo(expect);
    }
}
