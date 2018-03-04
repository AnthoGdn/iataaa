package com.iataaa.checkersRules.rules;

import com.iataaa.checkersRules.model.Case;

import java.util.Arrays;

public class CheckersCasesTool {

    public static Case[] moveCaseFrom(Case[] board, int sourcePosition, int targetPosition) {
        Case[] result = Arrays.copyOf(board, board.length);
        result[targetPosition] = result[sourcePosition];
        result[sourcePosition] = Case.EMPTY;
        return result;
    }
}
