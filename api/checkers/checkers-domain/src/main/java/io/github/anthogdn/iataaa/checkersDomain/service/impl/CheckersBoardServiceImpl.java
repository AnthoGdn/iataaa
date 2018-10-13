package io.github.anthogdn.iataaa.checkersDomain.service.impl;

import io.github.anthogdn.iataaa.checkersDomain.model.Case;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;
import io.github.anthogdn.iataaa.checkersDomain.move.CheckersBoardMove;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard.PIECE_SIZE;
class CheckersBoardServiceImpl implements CheckersBoardService {

    CheckersBoardServiceImpl() {
    }

    @Override
    public CheckersBoard getInitializedCheckersBoard() {
        Case[] cases = new Case[PIECE_SIZE];
        for(int i = 0; i < PIECE_SIZE; ++i) {
            if (i < 20) cases[i] = Case.WHITE_PIECE;
            if (i >= 20 && i < 30) cases[i] = Case.EMPTY;
            if (i >= 30) cases[i] = Case.BLACK_PIECE;
        }
        return new CheckersBoard(cases);
    }

    @Override
    public boolean isValidMove(CheckersBoard board, CheckersBoard move, PlayerNb playerNb) {
        List<CheckersBoard> availableBoards = getAvailableMoves(board, playerNb);
        return availableBoards.contains(move);
    }

    @Override
    public List<CheckersBoard> getAvailableMoves(CheckersBoard board, PlayerNb playerNb) {
        return CheckersBoardMove.getAvailableMoves(board.getCases(), playerNb)
                .stream()
                .map(CheckersBoard::new)
                .collect(Collectors.toList());
    }
}
