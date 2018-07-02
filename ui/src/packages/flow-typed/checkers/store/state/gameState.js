// @flow
import type { Checkers } from '../../model/checkers';
import type { CheckersBoard } from '../../model/type/checkersBoard';

export type ActualMoveState = $ReadOnly<{|
  board: ?CheckersBoard,
  selectedPiecePosition: ?number,
  size: ?number,
|}>

export type GamesValuesState = $ReadOnly<{|
  ...?Checkers,
  actualMove: ActualMoveState,
|}>

export type GameState = $ReadOnly<{|
  values: GamesValuesState,
  isLoading: boolean,
  error: ?string
|}>
