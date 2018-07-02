package io.github.anthogdn.iataaa.checkersDomain.model;

import java.util.Arrays;

public enum Case {
    EMPTY(" "),
    BLACK_PIECE("o"),
    BLACK_QUEEN("O"),
    WHITE_PIECE("x"),
    WHITE_QUEEN("X");

    private final String representation;

    Case(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public static Case stringToCase(String s) {
        return Arrays
                .stream(values())
                .filter(c -> c.representation.equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return representation;
    }
}
