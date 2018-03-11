package com.iataaa.checkersRules.service;

import com.iataaa.checkersRules.model.CheckersBoard;
import com.iataaa.checkersRules.model.Player;

import java.util.List;

public interface CheckersRulesService {
    CheckersBoard getInitializedCheckersBoard();
    boolean isValidMove(CheckersBoard board, CheckersBoard move, Player p);
    List<CheckersBoard> getAvailableMoves(CheckersBoard board, Player p);
}
