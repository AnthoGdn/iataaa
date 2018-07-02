// @flow

import type { PlayerNb } from '../model/type/player';
import type { CheckersBoardDto } from './checkersDto';
import type { CheckersBoard } from '../model/type/checkersBoard';

export type CheckersPossibleMovesRequestDto = $ReadOnly<{|
  board: CheckersBoardDto,
  turnPlayer: PlayerNb,
|}>;

export type PossibleMoves = Array<CheckersBoard[]>;

export type CheckersBoardCasesDto = $ReadOnly<{|
  cases: CheckersBoard[],
|}>;

export type PossibleMovesResponseDto = $ReadOnly<{|
    possibleMoves: Array<CheckersBoardCasesDto>[],
|}>;
