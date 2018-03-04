package com.iataaa.checkersRules.service.impl;

import com.iataaa.checkersRules.model.Case;
import com.iataaa.checkersRules.model.CheckersBoard;
import com.iataaa.checkersRules.model.EnumPlayer;
import com.iataaa.checkersRules.rules.CheckersRules;
import com.iataaa.checkersRules.service.CheckersRulesService;

import java.util.List;
import java.util.stream.Collectors;

public class CheckersRulesServiceServiceImpl implements CheckersRulesService {

    @Override
    public CheckersBoard getInitializedCheckersBoard() {
        Case[] cases = new Case[50];
        for(int i = 0; i < 50; ++i) {
            if (i < 20) cases[i] = Case.WHITE_PIECE;
            if (i >= 20 && i < 30) cases[i] = Case.EMPTY;
            if (i >= 30) cases[i] = Case.BLACK_PIECE;
        }
        return new CheckersBoard(cases);
    }

    @Override
    public boolean isValidMove(CheckersBoard board, CheckersBoard move, EnumPlayer p) {
        List<CheckersBoard> availableBoards = getAvailableMoves(board, p);
        return availableBoards.contains(move);
    }

    @Override
    public List<CheckersBoard> getAvailableMoves(CheckersBoard board, EnumPlayer p) {
        return CheckersRules.getAvailableMoves(board.getCases(), p)
                .stream()
                .map(CheckersBoard::new)
                .collect(Collectors.toList());
    }
}
