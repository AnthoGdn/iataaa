package io.github.anthogdn.iataaa.checkersApi.service;

import io.github.anthogdn.iataaa.checkersApi.exception.NotFoundException;
import io.github.anthogdn.iataaa.checkersDto.entity.TokenDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersCreateDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersMoveWriteDto;
import io.github.anthogdn.iataaa.checkersDto.params.PageParams;
import org.springframework.data.domain.Page;

public interface CheckersEntityService {
    CreatedCheckersReadDto create(CheckersCreateDto checkersCreateDto);
    Page<CheckersReadDto> getAll(PageParams pageParams);
    CheckersReadDto getById(String id) throws NotFoundException;
    CheckersReadDto play(String id, CheckersMoveWriteDto move);
    CheckersReadDto surrender(String id, TokenDto tokenDto) throws NotFoundException;
}
