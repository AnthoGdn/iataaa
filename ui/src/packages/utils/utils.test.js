/* global define, describe, it, expect */

import { getMoveFromPossibleMoves, getPieceNb, isPossibleMoveCase } from './utils';
import {
  initialBoard,
  initialGameValues,
  initialPossibleMoves,
} from '../constants-for-tests/state/initialSituation';
import { complexGameValues, complexPossibleMoves } from '../constants-for-tests/state/complexSituation';
import { Cases } from '../flow-typed/checkers/model/type/case';

describe('isPossibleMoveCase', () => {
  it('should return true on initialize situation', () => {
    expect(isPossibleMoveCase(
      20, initialGameValues.actualMove, initialPossibleMoves
    ))
      .toBeTruthy();
  });

  it('should return false on initialize situation when black piece is selected', () => {
    expect(isPossibleMoveCase(
      30, initialGameValues.actualMove, initialPossibleMoves
    ))
      .toBeFalsy();
  });

  it('should return false on initialize situation when white piece is selected without possible position', () => {
    expect(isPossibleMoveCase(
      0, initialGameValues.actualMove, initialPossibleMoves
    ))
      .toBeFalsy();
  });

  it('should return true on complex situation', () => {
    expect(isPossibleMoveCase(
      23, complexGameValues.actualMove, complexPossibleMoves
    ))
      .toBeTruthy();
  });

  it('should return false on complex situation because move is impossible', () => {
    expect(isPossibleMoveCase(
      18, complexGameValues.actualMove, complexPossibleMoves
    ))
      .toBeFalsy();
  });
  it('should return true on complex situation in second tour', () => {
    expect(isPossibleMoveCase(
      12,
      { ...complexGameValues.actualMove, size: 1, selectedPiecePosition: 23 },
      complexPossibleMoves
    ))
      .toBeTruthy();
  });
});

describe('getPieceNb', () => {
  it('getPieceNb in normal situation', () => {
    expect(getPieceNb(
      initialBoard, Cases.WHITE_PIECE
    ))
      .toEqual(20);
  });

  it('getPieceNb with empty array', () => {
    expect(getPieceNb(
      [], Cases.WHITE_PIECE
    ))
      .toEqual(0);
  });
});

describe('getMoveFromPossibleMoves', () => {
  it('getMoveFromPossibleMoves', () => {
    expect(getMoveFromPossibleMoves(
      initialPossibleMoves.values, 15, 20, 0
    ))
      .toEqual(initialPossibleMoves.values[0][0]);
  });
});
