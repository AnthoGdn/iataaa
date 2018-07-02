package io.github.anthogdn.iataaa.checkersDto.entity;

import io.github.anthogdn.iataaa.checkersDto.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TokenDto implements Dto {
    @NotNull
    @Size(min = 1, max = 200)
    private String key;

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}
