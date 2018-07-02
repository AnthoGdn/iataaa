// @flow
import type { PossibleMovesState } from '../../flow-typed/checkers/store/state/possibleMovesState';
import { SET_POSSIBLE_MOVES, SET_POSSIBLE_MOVES_ERROR, SET_POSSIBLE_MOVES_LOADING } from './actions';
import possibleMovesInitialState from './state';

export default (
  state: PossibleMovesState = possibleMovesInitialState, action
): PossibleMovesState => {
  switch (action.type) {
  case SET_POSSIBLE_MOVES: return {
    ...state,
    values: action.possibleMoves,
  };
  case SET_POSSIBLE_MOVES_LOADING: return {
    ...state,
    isLoading: action.isLoading,
  };
  case SET_POSSIBLE_MOVES_ERROR: return {
    ...state,
    error: action.error,
  };
  default: return state;
  }
};
