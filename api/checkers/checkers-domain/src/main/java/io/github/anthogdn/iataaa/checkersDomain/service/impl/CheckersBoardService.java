package io.github.anthogdn.iataaa.checkersDomain.service.impl;

import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;

import java.util.List;

interface CheckersBoardService {
    CheckersBoard getInitializedCheckersBoard();
    boolean isValidMove(CheckersBoard board, CheckersBoard move, PlayerNb playerNb);
    List<CheckersBoard> getAvailableMoves(CheckersBoard board, PlayerNb playerNb);
}
