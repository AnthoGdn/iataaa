// @flow
import type { Id } from '../model/type/id';
import type { PlayerNb } from '../model/type/player';
import type { CheckersBoard } from '../model/type/checkersBoard';
import type { Token } from '../model/type/token';

export type CheckersBoardDto = $ReadOnly<{|
  cases: CheckersBoard
|}>;

export type CheckersToCreateDto = $ReadOnly<{|
  name: string,
  player: {
    name: string,
  },
|}>;

export type CreatedCheckersDto = $ReadOnly<{|
  checkersGame: {
    id: Id,
    name: string,
    board: CheckersBoardDto,
    player: {
      id: Id,
      name: string,
      playerNbDto: PlayerNb
    },
    turnPlayer: PlayerNb,
    winner: PlayerNb
  },
  token: {
    key: Token
  }
|}>;

export type CheckersDto = $ReadOnly<{|
  id: Id,
  name: string,
  board: CheckersBoardDto,
  player: {
      id: Id,
      name: string,
      playerNbDto: PlayerNb
  },
  turnPlayer: PlayerNb,
  winner: PlayerNb
|}>;

export type CheckersMoveRequestDto = $ReadOnly<{|
  move: CheckersBoardDto,
  token: {
    key: Token,
  }
|}>;
