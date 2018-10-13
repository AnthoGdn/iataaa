package io.github.anthogdn.iataaa.checkersDto.entity;

import io.github.anthogdn.iataaa.checkersDto.Dto;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

public class BoardDto<T> implements Dto {
    @NotNull
    private T cases[];

    public BoardDto() {
    }
    public BoardDto(T cases[]) {
        this.cases = cases;
    }

    public T[] getCases() {
        return cases;
    }
    public void setCases(T[] cases) {
        this.cases = cases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardDto)) return false;
        BoardDto<?> boardDto = (BoardDto<?>) o;
        return Arrays.equals(cases, boardDto.cases);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cases);
    }
}
