package io.github.anthogdn.iataaa.checkersTestUtil;

import io.github.anthogdn.iataaa.checkersDomain.model.Case;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDomain.model.Move;
import io.github.anthogdn.iataaa.checkersDomain.tools.CheckersCasesTool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MoveUtil {

    public static Set<Move> getInitialMoveSet() {
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
        Case[] cases = CheckersBoard.stringToCheckersBoard(boardString).getCases();


        return new HashSet<>(Arrays.asList(
            new Move(CheckersCasesTool.moveCaseFrom(cases, 15, 20)),
            new Move (CheckersCasesTool.moveCaseFrom(cases, 15, 21)),
            new Move (CheckersCasesTool.moveCaseFrom(cases, 16, 21)),
            new Move (CheckersCasesTool.moveCaseFrom(cases, 16, 22)),
            new Move (CheckersCasesTool.moveCaseFrom(cases, 17, 22)),
            new Move (CheckersCasesTool.moveCaseFrom(cases, 17, 23)),
            new Move (CheckersCasesTool.moveCaseFrom(cases, 18, 23)),
            new Move (CheckersCasesTool.moveCaseFrom(cases, 18, 24)),
            new Move (CheckersCasesTool.moveCaseFrom(cases, 19, 24))
        ));
    }
}
