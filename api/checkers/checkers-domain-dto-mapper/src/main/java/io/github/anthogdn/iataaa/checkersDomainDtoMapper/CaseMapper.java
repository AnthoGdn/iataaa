package io.github.anthogdn.iataaa.checkersDomainDtoMapper;

import io.github.anthogdn.iataaa.checkersDomain.model.Case;
import io.github.anthogdn.iataaa.checkersDto.type.CaseDto;

import java.util.Arrays;

public class CaseMapper {

    public static Case caseDtoToCase(CaseDto caseDto) {
        switch (caseDto) {
            case EMPTY: return Case.EMPTY;
            case BLACK_PIECE: return Case.BLACK_PIECE;
            case BLACK_QUEEN: return Case.BLACK_QUEEN;
            case WHITE_PIECE: return Case.WHITE_PIECE;
            case WHITE_QUEEN: return Case.WHITE_QUEEN;
            default: throw new IllegalArgumentException();
        }
    }

    public static CaseDto caseDtoToCase(Case aCase) {
        switch (aCase) {
            case EMPTY: return CaseDto.EMPTY;
            case BLACK_PIECE: return CaseDto.BLACK_PIECE;
            case BLACK_QUEEN: return CaseDto.BLACK_QUEEN;
            case WHITE_PIECE: return CaseDto.WHITE_PIECE;
            case WHITE_QUEEN: return CaseDto.WHITE_QUEEN;
            default: throw new IllegalArgumentException();
        }
    }

    public static CaseDto[] casesToCasesDTO(Case[] cases) {
        return Arrays
            .stream(cases)
            .map(CaseMapper::caseDtoToCase)
            .toArray(CaseDto[]::new);
    }
}
