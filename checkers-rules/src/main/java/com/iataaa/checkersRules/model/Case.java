package com.iataaa.checkersRules.model;

public enum Case {
    EMPTY(" "),
    BLACK_PIECE("o"),
    BLACK_QUEEN("O"),
    WHITE_PIECE("x"),
    WHITE_QUEEN("X");

    // ATTRIBUTES

    private final String representation;

    // CONSTRUCTOR

    Case(String representation) {
        this.representation = representation;
    }

    // REQUEST

    public String getRepresentation() {
        return representation;
    }

    public static Case stringToCase(String s) {
        switch (s) {
            case "o": return BLACK_PIECE;
            case "O": return BLACK_QUEEN;
            case "x": return WHITE_PIECE;
            case "X": return WHITE_QUEEN;
            default: return EMPTY;
        }
    }

    @Override
    public String toString() {
        return representation;
    }
}
