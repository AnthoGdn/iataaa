package io.github.anthogdn.iataaa.checkersDto.entity.read;

import io.github.anthogdn.iataaa.checkersDto.Dto;

import javax.validation.constraints.NotNull;
import java.util.UUID;

abstract class AbstractEntityReadDto implements Dto {
    @NotNull
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
