package io.github.anthogdn.iataaa.checkersDomain.service.impl;

import io.github.anthogdn.iataaa.checkersDomain.model.Checkers;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;
import io.github.anthogdn.iataaa.checkersDomain.service.CheckersService;

public class CheckersServiceImpl implements CheckersService {

    private CheckersBoardService checkersBoardService;

    public CheckersServiceImpl() {
        this.checkersBoardService = new CheckersBoardServiceImpl();
    }

    @Override
    public Checkers getInitializedCheckers() {
        CheckersBoard checkersBoard = checkersBoardService.getInitializedCheckersBoard();
        return new Checkers(checkersBoard, PlayerNb.PLAYER_1, null);
    }
}
