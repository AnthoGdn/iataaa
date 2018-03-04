package com.iataaa.checkersRules.rules;

import com.iataaa.checkersRules.model.Case;
import com.iataaa.checkersRules.model.CheckersBoard;
import com.iataaa.checkersRules.model.EnumPlayer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckersRulesForPlayerWithQueenTest {
    @Test
    public void getAvailableMovesToJumpPiece() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |   o   |       |   o   |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|   o   |       |   o   |       |   o   |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |   o   |       |   o   |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |   o   |       |   o   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |   x   |       |   o   |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   X   |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        List<Case[]> expected = Arrays.asList(
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 5),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 11),
                CheckersCasesTool.moveCaseFrom(initialBoard, 16, 21),
                CheckersCasesTool.moveCaseFrom(initialBoard, 16, 22)
        );

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(results).containsOnlyElementsOf(expected);
    }

    @Test
    public void getAvailableMovesToJumpQueen() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |   O   |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   X   |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        List<Case[]> expected = Arrays.asList(
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 5),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 11),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 16),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 22),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 27),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 33),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 38),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 44),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 49)
        );

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(results).containsOnlyElementsOf(expected);
    }

    @Test
    public void getAvailableMovesWithoutJump() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |   o   |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |   o   |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   X   |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        List<Case[]> expected = Arrays.asList(
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 5),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 11)
        );

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(results).containsOnlyElementsOf(expected);
    }


    @Test
    public void getAvailableMovesToJumpPieceUntilTheBoarder() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |   o   |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   X   |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        List<Case[]> expected = Arrays.asList(
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 22),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 27),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 33),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 38),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 44),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 49)
        );
        expected.forEach((e) -> e[16] = Case.EMPTY);

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(results).containsOnlyElementsOf(expected);
    }

    @Test
    public void getAvailableMovesToJumpTwoPieces() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |       |       |   o   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |   o   |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   X   |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        List<Case[]> expected = Arrays.asList(
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 18),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 14),
                CheckersCasesTool.moveCaseFrom(initialBoard, 0, 9)
        );
        expected.forEach(e -> {
            e[16] = Case.EMPTY;
            e[23] = Case.EMPTY;
        });

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(results).containsOnlyElementsOf(expected);
    }

    @Test
    public void getAvailableMovesToJumpThreePieces() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |   o   |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |   o   |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |   o   |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   X   |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        String expectedBoardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |   X   |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|       |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard expectedCheckersBoard = CheckersBoard.stringToCheckersBoard(expectedBoardString);
        Case[] expected = expectedCheckersBoard.getCases();

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(results).containsOnly(expected);
    }

    @Test
    public void getAvailableMovesToJumpFourPieces
            () {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |   o   |       |   o   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |   o   |       |   o   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |   X   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|       |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        List<Case[]> expected = Arrays.asList(
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 17),
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 12),
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 6),
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 1)
        );
        expected.forEach( e -> {
            e[22] = Case.EMPTY;
            e[32] = Case.EMPTY;
            e[33] = Case.EMPTY;
            e[23] = Case.EMPTY;
        });

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(results).containsExactlyElementsOf(expected);
    }

    @Test
    public void getAvailableMovesToJumpFivePieces() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |   o   |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |   o   |       |   o   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |   o   |       |   o   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |   X   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|       |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        List<Case[]> expected = Arrays.asList(
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 17),
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 12),
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 6),
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 1)
        );
        expected.forEach( e -> {
            e[22] = Case.EMPTY;
            e[32] = Case.EMPTY;
            e[33] = Case.EMPTY;
            e[23] = Case.EMPTY;
        });

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(results).containsExactlyElementsOf(expected);
    }

    @Test
    public void getAvailableMovesToBack() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |   o   |       |       |       |   X   |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|   o   |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |   o   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|   o   |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|       |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        List<Case[]> expected = Arrays.asList(
                CheckersCasesTool.moveCaseFrom(initialBoard, 47, 42),
                CheckersCasesTool.moveCaseFrom(initialBoard, 47, 36),
                CheckersCasesTool.moveCaseFrom(initialBoard, 47, 31),
                CheckersCasesTool.moveCaseFrom(initialBoard, 47, 25),
                CheckersCasesTool.moveCaseFrom(initialBoard, 47, 43),
                CheckersCasesTool.moveCaseFrom(initialBoard, 47, 38),
                CheckersCasesTool.moveCaseFrom(initialBoard, 47, 34),
                CheckersCasesTool.moveCaseFrom(initialBoard, 47, 29)
        );

        // WHEN
        List<Case[]> result = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(result).containsOnlyElementsOf(expected);
    }

    @Test
    public void getAvailableMovesWithTwoChoices() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |   o   |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |   X   |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |   o   |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|       |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        String expectedBoardString1 =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|   X   |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |   o   |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|       |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard expectedCheckersBoard1 = CheckersBoard.stringToCheckersBoard(expectedBoardString1);
        Case[] expected1 = expectedCheckersBoard1.getCases();

        String expectedBoardString2 =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |   o   |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|       |       |       |       |       |       |       |       |   X   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard expectedCheckersBoard2 = CheckersBoard.stringToCheckersBoard(expectedBoardString2);
        Case[] expected2 = expectedCheckersBoard2.getCases();

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_1);

        // THEN
        assertThat(results).containsOnly(expected1, expected2);
    }

    @Test
    public void getAvailableMovesToJumpFivePiecesForPlayer2() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |   x   |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |       |       |   x   |       |   x   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "5|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "4|       |       |       |       |   x   |       |   x   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "3|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|       |       |       |       |       |       |   O   |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|       |       |       |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        List<Case[]> expected = Arrays.asList(
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 17),
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 12),
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 6),
                CheckersCasesTool.moveCaseFrom(initialBoard, 13, 1)
        );
        expected.forEach(e-> {
            e[22] = Case.EMPTY;
            e[23] = Case.EMPTY;
            e[32] = Case.EMPTY;
            e[33] = Case.EMPTY;
        });

        // WHEN
        List<Case[]> results = CheckersRules.getAvailableMoves(initialBoard, EnumPlayer.PLAYER_2);

        // THEN
        assertThat(results).containsExactlyElementsOf(expected);
    }
}
