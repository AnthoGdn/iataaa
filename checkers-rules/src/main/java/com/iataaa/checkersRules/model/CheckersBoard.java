package com.iataaa.checkersRules.model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckersBoard {
    private Case[] cases;

    public CheckersBoard(Case[] cases) {
        assert boardIsValid(cases);
        this.cases = cases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckersBoard)) return false;
        CheckersBoard that = (CheckersBoard) o;
        return Arrays.equals(getCases(), that.getCases());
    }

    public Case[] getCases() {
        return cases;
    }

    public static ValidityCheckersBoard validate(Case[] cases) {
        Set<ValidityErrorCheckersBoard> errors = new HashSet<>();
        if (cases == null) {
            errors.add(ValidityErrorCheckersBoard.CASES_ARRAY_IS_NULL);
            errors.add(ValidityErrorCheckersBoard.CASES_ARRAY_LENGTH_NOT_EQUAL_50);
            errors.add(ValidityErrorCheckersBoard.CASES_ARRAY_CONTAINS_NULL);
        } else {
            if (cases.length != 50) {
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
        return Arrays.hashCode(getCases());
    }

    public static CheckersBoard stringToCheckersBoard(String boardString) {
        Case[] cases = new Case[50];
        Pattern pattern = Pattern.compile("\\|\\s{3}[oOxX ]\\s{3}");
        Matcher matcher = pattern.matcher(boardString);
        int k = 0;
        while (matcher.find()) {
            Case c = Case.stringToCase(matcher.group().charAt(4) + "");
            if (isWhiteCase(k)) {
                int i = (45 - 10 * (k / 10) / 2) + ((k % 10) / 2);
                cases[i] = c;
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

        for (int i = 9; i >= 0; --i) {
            str.append(line).append(i).append("|");
            for (int j = 0; j < 10; j++) {
                str.append("   ").append(board[i][j].toString()).append("   |");
            }

            str.append("\n");
        }
        str.append(firstLine);
        return str.toString();
    }

    // PRIVATE
    private boolean boardIsValid(Case[] cases) {
        return cases != null
                && cases.length == 50
                && Arrays.stream(cases).noneMatch(Objects::isNull);
    }

    /*
     * Convert the Case[50] board in Case[10][10] board.
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
            int row = (i / 5);
            int column = ((i / 5) % 2) + (i % 5 * 2);
            boardFinal[row][column] = boardFifty[i];
        }
        return boardFinal;
    }

    /*
     * Get a line of the board string.
     */
    private String getAbscissaLine(int n) {
        StringBuilder line = new StringBuilder(" |");
        for (int i = 0; i < n; i++) {
            line.append("---").append(i).append("---|");
        }
        return line + "\n";
    }

    /*
     * Get a line of the board string.
     */
    private String getLine(int n) {
        StringBuilder line = new StringBuilder(" |");
        for (int i = 0; i < n; i++) {
            line.append("-------|");
        }
        return line + "\n";
    }

    private static boolean isWhiteCase(int k) {
        return (k / 10) % 2 == 0 && k % 2 == 1 || (k / 10) % 2 == 1 && k % 2 == 0;
    }
}
