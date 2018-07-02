package io.github.anthogdn.iataaa.checkersApi.controller;

import io.github.anthogdn.iataaa.checkersApi.exception.NotAuthorizedException;
import io.github.anthogdn.iataaa.checkersApi.service.CheckersEntityService;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.read.CreatedCheckersReadDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersCreateDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersMoveWriteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static io.github.anthogdn.iataaa.checkersApi.Path.API_PATH;

@RestController
@RequestMapping(API_PATH + "/checkers")
public class CheckersController {

    private CheckersEntityService checkersEntityService;

    public CheckersController(@Autowired CheckersEntityService checkersEntityService) {
        this.checkersEntityService = checkersEntityService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCheckersReadDto create(@RequestBody @Valid CheckersCreateDto checkersCreateDto) {
        return checkersEntityService.create(checkersCreateDto);
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public Page<CheckersReadDto> getAll(@Valid PageParams pageParams) {
//        return null;
//    }
//
//    @GetMapping(value = "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public CheckersReadDto getById(@PathVariable("id") UUID id) throws NotFoundException {
//        return null;
//    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CheckersReadDto play(
            @PathVariable("id") String id,
            @RequestBody @Valid CheckersMoveWriteDto move
    ) throws NotAuthorizedException {
        return checkersEntityService.play(id, move);
    }

//    @PutMapping(value = "/surrender/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public CheckersReadDto surrender(@PathVariable("id") UUID id, @Valid TokenDto token) throws NotFoundException {
//        return null;
//    }
}
