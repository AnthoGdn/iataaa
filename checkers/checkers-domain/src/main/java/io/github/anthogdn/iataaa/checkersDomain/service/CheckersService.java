package io.github.anthogdn.iataaa.checkersDomain.service;

import io.github.anthogdn.iataaa.checkersDomain.model.Checkers;
import io.github.anthogdn.iataaa.checkersDomain.model.CheckersBoard;
import io.github.anthogdn.iataaa.checkersDomain.model.PlayerNb;
import io.github.anthogdn.iataaa.checkersDomain.model.ValidityCheckersMoveException;

public interface CheckersService {
    Checkers getInitializedCheckers();
    Checkers play(Checkers initialCheckers, PlayerNb turnPlayer, CheckersBoard move) throws ValidityCheckersMoveException;
    Checkers playAi(Checkers checkers, PlayerNb turnPlayer) throws ValidityCheckersMoveException;
}
