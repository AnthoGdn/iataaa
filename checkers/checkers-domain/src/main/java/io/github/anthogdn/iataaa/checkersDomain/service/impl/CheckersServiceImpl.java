package io.github.anthogdn.iataaa.checkersDomain.service.impl;

import io.github.anthogdn.iataaa.checkersDomain.model.*;
import io.github.anthogdn.iataaa.checkersDomain.service.CheckersService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    @Override
    public Checkers play(
            Checkers initialCheckers, PlayerNb turnPlayer, CheckersBoard move
    ) throws ValidityCheckersMoveException {
        // Checkers is over ?
        if (initialCheckers.getWinner() != null) {
            ValidityErrorsCheckersMove error = ValidityErrorsCheckersMove.CHECKERS_IS_OVER;
            throw new ValidityCheckersMoveException(error);
        }
        // Is good player turn ?
        if (initialCheckers.getTurnPlayer() != turnPlayer) {
            ValidityErrorsCheckersMove error = ValidityErrorsCheckersMove.IS_NOT_TURN_PLAYER;
            throw new ValidityCheckersMoveException(error);
        }
        // Is right move ?
        if (!checkersBoardService.isValidMove(initialCheckers.getCheckersBoard(), move, turnPlayer)) {
            ValidityErrorsCheckersMove error = ValidityErrorsCheckersMove.MOVE_IS_NOT_VALIDATE;
            throw new ValidityCheckersMoveException(error);
        }

        // Verifier si c'est la fin du jeu
        PlayerNb winner = null;
        if (isEndCheckers(move)) {
            winner = turnPlayer;
        }

        return new Checkers(move, PlayerNb.getNextPlayer(turnPlayer), winner);
    }

    public Checkers playAi(Checkers checkers, PlayerNb turnPlayer) throws ValidityCheckersMoveException {
        // Checkers is over ?
        if (checkers.getWinner() != null) {
            ValidityErrorsCheckersMove error = ValidityErrorsCheckersMove.CHECKERS_IS_OVER;
            throw new ValidityCheckersMoveException(error);
        }
        // Is good player turn ?
        if (checkers.getTurnPlayer() != turnPlayer) {
            ValidityErrorsCheckersMove error = ValidityErrorsCheckersMove.IS_NOT_TURN_PLAYER;
            throw new ValidityCheckersMoveException(error);
        }

        List<CheckersBoard> moves = checkersBoardService
                .getAvailableMoves(checkers.getCheckersBoard(), turnPlayer);
        CheckersBoard move = moves.get(new Random().nextInt(moves.size()));

        // Verifier si c'est la fin du jeu
        PlayerNb winner = null;
        if (isEndCheckers(move)) {
            winner = turnPlayer;
        }

        return new Checkers(move, PlayerNb.getNextPlayer(turnPlayer), winner);
    }

    boolean isEndCheckers(CheckersBoard board) {
        boolean isEnd;
        isEnd = Arrays.stream(board.getCases())
                    .allMatch(c -> c == Case.WHITE_PIECE || c == Case.WHITE_QUEEN || c == Case.EMPTY);

        isEnd = isEnd || Arrays.stream(board.getCases())
                .allMatch(c -> c == Case.BLACK_PIECE || c == Case.BLACK_QUEEN || c == Case.EMPTY);

        return isEnd;
    }
}
