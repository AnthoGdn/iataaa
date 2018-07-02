package io.github.anthogdn.iataaa.checkersDto.entity;

import io.github.anthogdn.iataaa.checkersDto.type.CaseDto;

public class CheckersBoardDto extends BoardDto<CaseDto> {
    public CheckersBoardDto() {
        super();
    }
    public CheckersBoardDto(CaseDto cases[]) {
        super(cases);
    }
}
