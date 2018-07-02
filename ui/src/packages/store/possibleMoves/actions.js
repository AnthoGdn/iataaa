// @flow

import { getPossiblesChainMoves } from '../../requester/checkersMoveApi';
import { mapPossibleMovesResponseDtoToPossibleMove } from '../../mapper/possibleMovesMapper';
import { PLAYER_1 } from '../../contants/constants';

export const SET_POSSIBLE_MOVES: string = 'SET_POSSIBLE_MOVES';
const setPossibleMovesAction = possibleMoves => ({
  type: SET_POSSIBLE_MOVES,
  possibleMoves,
});

export const SET_POSSIBLE_MOVES_LOADING: string = 'SET_POSSIBLE_MOVES_LOADING';
const setLoadingPossibleMovesAction = (isLoading: boolean) => ({
  type: SET_POSSIBLE_MOVES_LOADING,
  isLoading,
});

export const SET_POSSIBLE_MOVES_ERROR: string = 'SET_POSSIBLE_MOVES_ERROR';
const setErrorPossibleMovesAction = (error: string) => ({
  type: SET_POSSIBLE_MOVES_ERROR,
  error,
});


export const getPossibleMoveAction = () => (dispatch, getState) => {
  dispatch(setLoadingPossibleMovesAction(true));
  getPossiblesChainMoves(getState().game.values.actualMove.board, PLAYER_1)
    .then(response => mapPossibleMovesResponseDtoToPossibleMove(response.data))
    .then(possibleMoves => dispatch(setPossibleMovesAction(possibleMoves)))
    .then(() => dispatch(setLoadingPossibleMovesAction(false)))
    .catch((error) => {
      dispatch(setErrorPossibleMovesAction(error));
    });
};
