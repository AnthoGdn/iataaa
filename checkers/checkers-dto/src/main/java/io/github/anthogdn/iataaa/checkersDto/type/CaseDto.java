package io.github.anthogdn.iataaa.checkersDto.type;

import java.util.Arrays;

public enum CaseDto {
    EMPTY(" "),
    BLACK_PIECE("o"),
    BLACK_QUEEN("O"),
    WHITE_PIECE("x"),
    WHITE_QUEEN("X");

    private final String representation;

    CaseDto(String representation) {
        this.representation = representation;
    }

    public static CaseDto stringToCaseDto(String s) {
        return Arrays
                .stream(values())
                .filter(c -> c.representation.equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
