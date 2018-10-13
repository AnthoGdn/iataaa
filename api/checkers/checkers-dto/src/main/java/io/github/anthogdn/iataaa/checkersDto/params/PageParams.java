package io.github.anthogdn.iataaa.checkersDto.params;

import io.github.anthogdn.iataaa.checkersDto.Dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PageParams implements Dto {
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int page;
    @Min(1)
    @Max(50)
    private int perPage;

    public PageParams() {
        this.page = 0;
        this.perPage = 10;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }
}
