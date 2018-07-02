// @flow

import axios from 'axios';
import type {
  CheckersPossibleMovesRequestDto,
  PossibleMovesResponseDto,
} from '../flow-typed/checkers/dto/checkersMoveDto';
import type { PlayerNb } from '../flow-typed/checkers/model/type/player';
import type { CheckersBoard } from '../flow-typed/checkers/model/type/checkersBoard';

export const getPossiblesChainMoves = (
  board: CheckersBoard, turnPlayer: PlayerNb
): Promise<PossibleMovesResponseDto> => {
  const body: CheckersPossibleMovesRequestDto = {
    board: {
      cases: board,
    },
    turnPlayer,
  };
  return axios.put('/checkers-rules-api/v1/checkers/moves', body, {
    credentials: 'same-origin',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
    },
  });
};
