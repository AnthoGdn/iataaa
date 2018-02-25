package io.github.anthogdn.iataaa.checkersDomain;

import io.github.anthogdn.iataaa.checkersDomain.model.Case;

import java.util.Arrays;

public class CheckersCasesTool {

    public static Case[] moveCaseFrom(Case[] board, int sourcePosition, int targetPosition) {
        Case[] result = Arrays.copyOf(board, board.length);
        result[targetPosition] = result[sourcePosition];
        result[sourcePosition] = Case.EMPTY;
        return result;
    }
}
