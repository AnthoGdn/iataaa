package io.github.anthogdn.iataaa.checkersDomain.move;

import io.github.anthogdn.iataaa.checkersDomain.model.Case;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckersRulesPrivateMethodsTest {
    @Test
    public void getAllTopRightCornerPositionTest() {
        int i = 2;
        List<Integer> res = new ArrayList<>();
        res.add(7);
        res.add(13);
        res.add(18);
        res.add(24);
        res.add(29);

        List<Integer> test = CheckersBoardMove.getAllTopRightCornerPositions(i);
        assertThat(test).isEqualTo(res);
    }

    @Test
    public void getAllBottomLeftCornerPositionTest() {
        int i = 14;
        List<Integer> res = new ArrayList<>();
        res.add(8);
        res.add(3);

        List<Integer> test = CheckersBoardMove.getAllBottomLeftCornerPositions(i);
        assertThat(test).isEqualTo(res);
    }

    @Test
    public void getAllBottomRightCornerPositionTest() {
        int i = 23;
        List<Integer> res = new ArrayList<>();
        res.add(18);
        res.add(14);
        res.add(9);

        List<Integer> test = CheckersBoardMove.getAllBottomRightCornerPositions(i);
        assertThat(test).isEqualTo(res);
    }

    @Test
    public void getAllBottomRightCornerPositionReturnEmptyTest() {
        int i = 19;
        List<Integer> res = new ArrayList<>();

        List<Integer> test = CheckersBoardMove.getAllBottomRightCornerPositions(i);
        assertThat(test).isEqualTo(res);
    }

    @Test
    public void getTopLeftCornerPositionAfterJumpTest1() {
        int src = 5;
        int result = CheckersBoardMove.getTopLeftCornerPosition(src, 2);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void getTopLeftCornerPositionAfterJumpTest2() {
        int src = 19;
        int result = CheckersBoardMove.getTopLeftCornerPosition(src, 2);

        assertThat(result).isEqualTo(28);
    }

    @Test
    public void getTopRightCornerPositionAfterJumpTest1() {
        int src = 5;
        int result = CheckersBoardMove.getTopRightCornerPosition(src, 2);

        assertThat(result).isEqualTo(16);
    }

    @Test
    public void getTopRightCornerPositionAfterJumpTest2() {
        int src = 19;
        int result = CheckersBoardMove.getTopRightCornerPosition(src, 2);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void getBottomLeftCornerPositionAfterJumpTest1() {
        int src = 5;
        int result = CheckersBoardMove.getBottomLeftCornerPosition(src, 2);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void getBottomLeftCornerPositionAfterJumpTest2() {
        int src = 19;
        int result = CheckersBoardMove.getBottomLeftCornerPosition(src, 2);

        assertThat(result).isEqualTo(8);
    }

    @Test
    public void getBottomRightCornerPositionAfterJumpTest1() {
        int src = 5;
        int result = CheckersBoardMove.getBottomRightCornerPosition(src, 2);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void getBottomRightCornerPositionAfterJumpTest2() {
        int src = 17;
        int result = CheckersBoardMove.getBottomRightCornerPosition(src, 2);

        assertThat(result).isEqualTo(8);
    }

    /*---------------------------------------*/
    // reverseCases Tests
    /*---------------------------------------*/
    @Test
    public void reverseCasesWithOneBlackPiece() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "8|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "7|       |       |       |       |       |       |       |       |       |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "6|       |       |   o   |       |       |       |       |       |       |       |\n" +
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
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        String expectedBoardString =
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
            "3|       |       |       |       |       |       |       |   x   |       |       |\n" +
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
        Case[] result = CheckersBoardMove.reverseCases(initialBoard);

        // THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void reverseCasesWithInitializedBlackPieces() {
        // GIVEN
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

        String expectedBoardString =
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
            "3|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard expectedCheckersBoard = CheckersBoard.stringToCheckersBoard(expectedBoardString);
        Case[] expected = expectedCheckersBoard.getCases();

        // WHEN
        Case[] result = CheckersBoardMove.reverseCases(initialBoard);

        // THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void reverseCasesWithInitializedWhitePieces() {
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
            "3|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "2|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "1|       |   x   |       |   x   |       |   x   |       |   x   |       |   x   |\n" +
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "0|   x   |       |   x   |       |   x   |       |   x   |       |   x   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

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
        Case[] result = CheckersBoardMove.reverseCases(initialBoard);

        // THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void reverseCasesWithInitializedBoard() {
        // GIVEN
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
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

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
        CheckersBoard expectedCheckersBoard = CheckersBoard.stringToCheckersBoard(expectedBoardString);
        Case[] expected = expectedCheckersBoard.getCases();

        // WHEN
        Case[] result = CheckersBoardMove.reverseCases(initialBoard);

        // THEN
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void reverseCasesWithPieceAndQueenBoard() {
        // GIVEN
        String boardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |   o   |       |   O   |       |       |       |       |       |       |\n" +
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
            "0|   x   |       |   X   |       |       |       |       |       |       |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard checkersboard = CheckersBoard.stringToCheckersBoard(boardString);
        Case[] initialBoard = checkersboard.getCases();

        String expectedBoardString =
            " |-------|-------|-------|-------|-------|-------|-------|-------|-------|-------|\n" +
            "9|       |       |       |       |       |       |       |   O   |       |   o   |\n" +
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
            "0|       |       |       |       |       |       |   X   |       |   x   |       |\n" +
            " |---0---|---1---|---2---|---3---|---4---|---5---|---6---|---7---|---8---|---9---|";
        CheckersBoard expectedCheckersBoard = CheckersBoard.stringToCheckersBoard(expectedBoardString);
        Case[] expected = expectedCheckersBoard.getCases();

        // WHEN
        Case[] result = CheckersBoardMove.reverseCases(initialBoard);

        // THEN
        assertThat(result).isEqualTo(expected);
    }
}
