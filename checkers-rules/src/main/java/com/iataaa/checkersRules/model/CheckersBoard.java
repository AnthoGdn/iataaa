package com.iataaa.checkersRules.model;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckersBoard {
    public final static String WHITE_CASE_REPRESENTATION = "\\|\\s{3}[oOxX ]\\s{3}";
    public final static int PIECE_POSITION_OF_REPRESENTATION = 4;
    public final static int FIRST_PIECE_POSITION_AT_THE_TOP = 45;
    public final static int PIECE_SIZE = 50;
    public final static int CASE_NB_OF_LINE = 5;
    public final static int LINE_NB = 10;
    public final static String BOARD_SIDE= "|";

    private Case[] cases;

    public CheckersBoard(Case[] cases) {
        assert boardIsValid(cases);
        this.cases = cases.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CheckersBoard)) {
            return false;
        }
        CheckersBoard that = (CheckersBoard) object;
        return Arrays.equals(getCases(), that.getCases());
    }

    public Case[] getCases() {
        return cases.clone();
    }

    public static ValidityCheckersBoard validate(Case[] cases) {
        Set<ValidityErrorCheckersBoard> errors = EnumSet.noneOf(ValidityErrorCheckersBoard.class);
        if (cases == null) {
            errors.add(ValidityErrorCheckersBoard.CASES_ARRAY_IS_NULL);
            errors.add(ValidityErrorCheckersBoard.CASES_ARRAY_LENGTH_NOT_EQUAL_50);
            errors.add(ValidityErrorCheckersBoard.CASES_ARRAY_CONTAINS_NULL);
        } else {
            if (cases.length != PIECE_SIZE) {
                errors.add(ValidityErrorCheckersBoard.CASES_ARRAY_LENGTH_NOT_EQUAL_50);
            }
            if (Arrays.stream(cases).anyMatch(Objects::isNull)) {
                errors.add(ValidityErrorCheckersBoard.CASES_ARRAY_CONTAINS_NULL);
            }
        }

        return errors.isEmpty() ? new ValidityCheckersBoard() : new ValidityCheckersBoard(errors);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cases);
    }

    public static CheckersBoard stringToCheckersBoard(String boardString) {
        Case[] cases = new Case[PIECE_SIZE];
        Pattern pattern = Pattern.compile(WHITE_CASE_REPRESENTATION);
        Matcher matcher = pattern.matcher(boardString);
        int k = 0;
        while (matcher.find()) {
            Case aCase = Case.stringToCase(String.valueOf(matcher.group().charAt(PIECE_POSITION_OF_REPRESENTATION)));
            if (isWhiteCase(k)) {
                int i = (FIRST_PIECE_POSITION_AT_THE_TOP - LINE_NB * (k / LINE_NB) / 2) + ((k % LINE_NB) / 2);
                cases[i] = aCase;
            }
            ++k;
        }

        return new CheckersBoard(cases);
    }

    @Override
    public String toString() {
        Case[][] board = convertFiftyToHundredBoard(cases);

        String firstLine = getAbscissaLine(board.length);
        String line = getLine(board.length);
        StringBuilder str = new StringBuilder();

        for (int i = LINE_NB - 1; i >= 0; --i) {
            str.append(line).append(i).append(BOARD_SIDE);
            for (int j = 0; j < LINE_NB; j++) {
                str.append("   ").append(board[i][j].toString()).append("   ").append(BOARD_SIDE);
            }

            str.append("\n");
        }
        str.append(firstLine);
        return str.toString();
    }

    // PRIVATE
    private boolean boardIsValid(Case[] cases) {
        return cases != null
                && cases.length == PIECE_SIZE
                && Arrays.stream(cases).noneMatch(Objects::isNull);
    }

    /*
     * Convert the Case[PIECE_SIZE] board in Case[10][10] board.
     */
    private Case[][] convertFiftyToHundredBoard(Case[] boardFifty) {
        Case[][] boardFinal = new Case[10][10];

        // initialize empty boardFinal
        Arrays.stream(boardFinal).forEach(cases -> {
            for (int j = 0; j < cases.length; j++) {
                cases[j] = Case.EMPTY;
            }
        });

        for (int i = 0; i < boardFifty.length; i++) {
            int row = (i / CASE_NB_OF_LINE);
            int column = ((i / CASE_NB_OF_LINE) % 2) + (i % CASE_NB_OF_LINE * 2);
            boardFinal[row][column] = boardFifty[i];
        }
        return boardFinal;
    }

    /*
     * Get a line of the board string.
     */
    private String getAbscissaLine(int n) {
        StringBuilder line = new StringBuilder(" ").append(BOARD_SIDE);
        for (int i = 0; i < n; i++) {
            line.append("---").append(i).append("---").append(BOARD_SIDE);
        }
        return line + "\n";
    }

    /*
     * Get a line of the board string.
     */
    private String getLine(int n) {
        StringBuilder line = new StringBuilder(" ").append(BOARD_SIDE);
        for (int i = 0; i < n; i++) {
            line.append("-------").append(BOARD_SIDE);
        }
        return line + "\n";
    }

    private static boolean isWhiteCase(int k) {
        return (k / 10) % 2 == 0 && k % 2 == 1 || (k / 10) % 2 == 1 && k % 2 == 0;
    }
}
