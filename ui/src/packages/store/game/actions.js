// @flow

import { createGameRequest, sendMoveRequest } from '../../requester/checkersApi';
import { mapCreatedCheckersDtoToCheckers } from '../../mapper/checkersMapper';
import { getPossibleMoveAction } from '../possibleMoves/actions';
import { dispatchRedirectionEvent } from '../../events/event';
import { getMoveFromPossibleMoves } from '../../utils/utils';

const TIMEOUT = 250;

export const SET_GAME: string = 'SET_GAME';
const setGameAction = checkers => ({
  type: SET_GAME,
  checkers,
});

export const SET_GAME_LOADING: string = 'SET_GAME_LOADING';
const setLoadingGameAction = (isLoading: boolean) => ({
  type: SET_GAME_LOADING,
  isLoading,
});

export const SET_GAME_ERROR: string = 'SET_GAME_ERROR';
const setErrorGameAction = error => ({
  type: SET_GAME_ERROR,
  error,
});

export const SET_ADVERSARY_MOVE: string = 'SET_ADVERSARY_MOVE';
const setAdversaryMoveAction = board => ({
  type: SET_ADVERSARY_MOVE,
  board,
});

export const SET_PIECE_POSITION: string = 'SET_PIECE_POSITION';
export const setPiecePositionAction = (position: number) => ({
  type: SET_PIECE_POSITION,
  position,
});

export const SET_MOVE_PIECE: string = 'SET_MOVE_PIECE';
export const setMovePieceAction = board => ({
  type: SET_MOVE_PIECE,
  board,
});

export const SET_TURN_TO_PLAYER_1: string = 'SET_TURN_TO_PLAYER_1';
export const setTurnToPlayer1 = () => ({
  type: SET_TURN_TO_PLAYER_1,
});

export const SET_TURN_TO_PLAYER_2: string = 'SET_TURN_TO_PLAYER_2';
export const setTurnToPlayer2 = () => ({
  type: SET_TURN_TO_PLAYER_2,
});

export const createGameAction = (checkersName: string, playerName: string) => (dispatch) => {
  dispatch(setLoadingGameAction(true));
  createGameRequest(checkersName, playerName)
    .then(response => dispatch(setGameAction(mapCreatedCheckersDtoToCheckers(response.data))))
    .then(() => dispatch(setLoadingGameAction(false)))
    .then(() => dispatchRedirectionEvent())
    .then(() => dispatch(getPossibleMoveAction()))
    .catch(() => {
      dispatch(setLoadingGameAction(false));
      dispatch(setErrorGameAction(true));
    });
};

export const sendMoveAction = () => (dispatch, getState) => {
  const state = getState();
  const gameValues = state.game.values;
  const { actualMove } = gameValues;
  dispatch(setLoadingGameAction(true));
  dispatch(setTurnToPlayer2());
  sendMoveRequest(gameValues.id, gameValues.token, actualMove.board)
    .then((response) => {
      setTimeout(() => {
        dispatch(setAdversaryMoveAction(response.data.board.cases));
        dispatch(setTurnToPlayer1());
        dispatch(setLoadingGameAction(false));
        dispatch(getPossibleMoveAction());
      }, TIMEOUT);
    })
    .catch(error => dispatch(setErrorGameAction(error)));
};

export const movePieceAction = (position: number) => (dispatch, getState) => {
  const state = getState();
  if (!state.game.values.winner) {
    const { actualMove } = state.game.values;
    dispatch(setMovePieceAction(
      getMoveFromPossibleMoves(
        state.possibleMoves.values,
        actualMove.selectedPiecePosition,
        position,
        actualMove.size
      ),
      position
    ));
    if (actualMove.size + 1 >= state.possibleMoves.values[0].length) {
      dispatch(sendMoveAction());
    }
  }
};
