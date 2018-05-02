package io.github.anthogdn.iataaa.checkersApi.service;

import io.github.anthogdn.iataaa.checkersApi.exception.NotAuthorizedException;
import io.github.anthogdn.iataaa.checkersApi.exception.NotFoundException;
import io.github.anthogdn.iataaa.checkersDto.entity.TokenDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersCreateDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersMoveWriteDto;
import io.github.anthogdn.iataaa.checkersDto.params.PageParams;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface CheckersEntityService {
    CreatedCheckersReadDto create(CheckersCreateDto checkersCreateDto);
    Page<CheckersReadDto> getAll(PageParams pageParams);
    CheckersReadDto getById(UUID id) throws NotFoundException;
    CheckersReadDto play(UUID id, CheckersMoveWriteDto move) throws NotAuthorizedException;
    CheckersReadDto surrender(UUID id, TokenDto tokenDto) throws NotFoundException;
}
