package io.github.anthogdn.iataaa.checkersRulesApi.controller;

import io.github.anthogdn.iataaa.checkersDto.entity.read.CheckersPossibleMovesResponseDto;
import io.github.anthogdn.iataaa.checkersDto.entity.write.CheckersPossibleMovesRequestDto;
import io.github.anthogdn.iataaa.checkersRulesApi.service.CheckersRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static io.github.anthogdn.iataaa.checkersRulesApi.Path.API_PATH;

@RestController
@RequestMapping(API_PATH + "/checkers/moves")
public class CheckersRulesController {

    private CheckersRulesService checkersRulesService;

    public CheckersRulesController(@Autowired CheckersRulesService checkersRulesService) {
        this.checkersRulesService = checkersRulesService;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CheckersPossibleMovesResponseDto getPossiblesChainMoves(@RequestBody @Valid CheckersPossibleMovesRequestDto requestDto) {
        return checkersRulesService.getPossiblesChainMoves(requestDto);
    }
}
