// @flow

import { Cases } from '../flow-typed/checkers/model/type/case';
import type { CheckersBoard } from '../flow-typed/checkers/model/type/checkersBoard';
import type { Case } from '../flow-typed/checkers/model/type/case';
import type { PossibleMovesState } from '../flow-typed/checkers/store/state/possibleMovesState';
import { ActualMoveState } from '../flow-typed/checkers/store/state/gameState';

export const isPossibleMoveCase = (
  casePosition: number, actualMove: ActualMoveState, possibleMoves: PossibleMovesState
) => {
  if (!actualMove.selectedPiecePosition || !possibleMoves || !possibleMoves.values) {
    return false;
  }
  return possibleMoves.values
    .some(
      moves => moves[actualMove.size][actualMove.selectedPiecePosition] === Cases.EMPTY
        && (
          moves[actualMove.size][casePosition] === Cases.WHITE_PIECE
          || moves[actualMove.size][casePosition] === Cases.WHITE_QUEEN
        ) && actualMove.board[casePosition] === Cases.EMPTY);
};

export const getPieceNb = (checkersBoard: CheckersBoard, piece: Case): number => checkersBoard
  .map(aCase => (aCase === piece ? 1 : 0))
  .reduce((accumulator, currentValue) => accumulator + currentValue, 0);

export const getMoveFromPossibleMoves = (
  possibleMoves,
  initializedPosition: number,
  finalPosition: number,
  size: number
) => possibleMoves.find(
  move => move[size][initializedPosition] === Cases.EMPTY
    && move[size][finalPosition] !== Cases.EMPTY
)[size];

export const gameIsOver = board =>
  !(
    board.some(acase => acase === Cases.WHITE_PIECE || acase === Cases.WHITE_QUEEN)
    && board.some(acase => acase === Cases.BLACK_PIECE || acase === Cases.BLACK_PIECE)
  );
