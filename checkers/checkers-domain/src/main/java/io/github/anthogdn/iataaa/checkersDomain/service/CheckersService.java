package io.github.anthogdn.iataaa.checkersDomain.service;

import io.github.anthogdn.iataaa.checkersDomain.model.*;

import java.util.Set;

public interface CheckersService {
    Set<Move> getAvailableChainMoves(Checkers initialCheckers);
    Checkers getInitializedCheckers();
    Checkers play(Checkers initialCheckers, PlayerNb turnPlayer, CheckersBoard move) throws ValidityCheckersMoveException;
    Checkers playAi(Checkers checkers, PlayerNb turnPlayer) throws ValidityCheckersMoveException;
}
