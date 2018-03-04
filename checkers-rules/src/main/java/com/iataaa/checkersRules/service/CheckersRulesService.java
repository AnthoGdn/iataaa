package com.iataaa.checkersRules.service;

import com.iataaa.checkersRules.model.CheckersBoard;
import com.iataaa.checkersRules.model.EnumPlayer;

import java.util.List;

public interface CheckersRulesService {
    CheckersBoard getInitializedCheckersBoard();
    boolean isValidMove(CheckersBoard board, CheckersBoard move, EnumPlayer p);
    List<CheckersBoard> getAvailableMoves(CheckersBoard board, EnumPlayer p);
}
