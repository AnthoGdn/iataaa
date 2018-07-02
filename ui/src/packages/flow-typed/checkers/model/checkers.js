// @flow
import type { CheckersBoard } from './type/checkersBoard';
import type { PlayerNb } from './type/player';
import type { Id } from './type/id';
import type { Token } from './type/token';

export type Checkers = $ReadOnly<{|
  id: Id,
  name: string,
  board: CheckersBoard,
  player: {
    id: Id,
    name: string,
    playerNb: PlayerNb
  },
  turnPlayer: PlayerNb,
  winner: ?PlayerNb,
  token: Token,
|}>;
