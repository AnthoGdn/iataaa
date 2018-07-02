import gameInitialState from './state';
import {
  SET_ADVERSARY_MOVE,
  SET_GAME,
  SET_GAME_ERROR,
  SET_GAME_LOADING,
  SET_MOVE_PIECE,
  SET_PIECE_POSITION, SET_TURN_TO_PLAYER_1, SET_TURN_TO_PLAYER_2,
} from './actions';
import { PLAYER_1, PLAYER_2 } from '../../contants/constants';
import { gameIsOver } from '../../utils/utils';

export default (state = gameInitialState, action) => {
  switch (action.type) {
  case SET_GAME: return {
    ...state,
    values: {
      ...action.checkers,
      actualMove: {
        ...state.values.actualMove,
        selectedPiecePosition: undefined,
        board: action.checkers.board,
        size: 0,
      },
    },
  };
  case SET_MOVE_PIECE: return {
    ...state,
    values: {
      ...state.values,
      board: action.board,
      actualMove: {
        ...state.values.actualMove,
        board: action.board,
        size: state.values.actualMove.size + 1,
        selectedPiecePosition: action.position,
      },
      winner: !state.values.winner && gameIsOver(action.board)
        ? state.values.player.playerNb
        : state.values.winner,
    },
  };
  case SET_ADVERSARY_MOVE: return {
    ...state,
    values: {
      ...state.values,
      board: action.board,
      actualMove: {
        ...state.actualMove,
        selectedPiecePosition: undefined,
        board: action.board,
        size: 0,
      },
      winner: !state.values.winner && gameIsOver(action.board)
        ? state.values.player.playerNb
        : state.values.winner,
    },
  };
  case SET_GAME_LOADING: return {
    ...state,
    isLoading: action.isLoading,
  };
  case SET_GAME_ERROR: return {
    ...state,
    error: action.error,
  };
  case SET_PIECE_POSITION: return {
    ...state,
    values: {
      ...state.values,
      actualMove: {
        ...state.values.actualMove,
        selectedPiecePosition: action.position,
      },
    },
  };
  case SET_TURN_TO_PLAYER_1: return {
    ...state,
    values: {
      ...state.values,
      turnPlayer: PLAYER_1,
    },
  };
  case SET_TURN_TO_PLAYER_2: return {
    ...state,
    values: {
      ...state.values,
      turnPlayer: PLAYER_2,
    },
  };
  default: return state;
  }
};
