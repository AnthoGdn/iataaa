package io.github.anthogdn.iataaa.checkersApi.mapper;

import io.github.anthogdn.iataaa.checkersDto.type.CaseDto;

public class CaseMapper {
    private CaseMapper() {
    }

    public static CaseDto stringToCaseDto(String s) {
        switch (s) {
            case " ":
                return CaseDto.EMPTY;
            case "x":
                return CaseDto.WHITE_PIECE;
            case "X":
                return CaseDto.WHITE_QUEEN;
            case "o":
                return CaseDto.BLACK_PIECE;
            case "O":
                return CaseDto.BLACK_QUEEN;
            default:
                throw new IllegalArgumentException("Impossible to map string");
        }
    }
}
