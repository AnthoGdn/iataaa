// @flow

import axios from 'axios';
import type {
  CheckersToCreateDto, CreatedCheckersDto, CheckersDto, CheckersMoveRequestDto,
} from '../flow-typed/checkers/dto/checkersDto';
import type { CheckersBoard } from '../flow-typed/checkers/model/type/checkersBoard';

export const createGameRequest = (
  checkersName: string, playerName: string
): Promise<CreatedCheckersDto> => {
  const body: CheckersToCreateDto = {
    name: checkersName,
    player: {
      name: playerName,
    },
  };
  return axios.post('/checkers-api/v1/checkers', body, {
    credentials: 'same-origin',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
    },
  });
};

export const sendMoveRequest = (
  id: string, token: string, board: CheckersBoard
): Promise<CheckersDto> => {
  const body: CheckersMoveRequestDto = {
    move: {
      cases: board,
    },
    token: {
      key: token,
    },
  };
  return axios.put(`/checkers-api/v1/checkers/${id}`, body, {
    credentials: 'same-origin',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json',
    },
  });
};
