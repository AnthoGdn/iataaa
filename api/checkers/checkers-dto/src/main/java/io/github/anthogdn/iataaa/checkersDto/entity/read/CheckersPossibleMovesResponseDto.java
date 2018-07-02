package io.github.anthogdn.iataaa.checkersDto.entity.read;

import io.github.anthogdn.iataaa.checkersDto.entity.CheckersBoardDto;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class CheckersPossibleMovesResponseDto {
    @NotNull
    private Set<List<CheckersBoardDto>> possibleMoves;

    public Set<List<CheckersBoardDto>> getPossibleMoves() {
        return possibleMoves;
    }
    public void setPossibleMoves(Set<List<CheckersBoardDto>> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }
}
