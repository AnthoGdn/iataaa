package io.github.anthogdn.iataaa.checkersDto.entity.write;

import io.github.anthogdn.iataaa.checkersDto.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlayerCreateDto implements Dto {
    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
