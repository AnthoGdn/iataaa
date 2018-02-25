package io.github.anthogdn.iataaa.checkersDto.entity.read;

import io.github.anthogdn.iataaa.checkersDto.Dto;

import javax.validation.constraints.NotNull;

abstract class AbstractEntityReadDto implements Dto {
    @NotNull
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
