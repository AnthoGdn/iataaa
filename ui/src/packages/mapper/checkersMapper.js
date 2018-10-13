// @flow
import type { CreatedCheckersDto } from '../flow-typed/checkers/dto/checkersDto';
import type { Checkers } from '../flow-typed/checkers/model/checkers';

export const mapCreatedCheckersDtoToCheckers = (
  createdCheckersDto: CreatedCheckersDto
): Checkers => ({
  id: createdCheckersDto.checkersGame.id,
  name: createdCheckersDto.checkersGame.name,
  board: createdCheckersDto.checkersGame.board.cases,
  player: {
    id: createdCheckersDto.checkersGame.player.id,
    name: createdCheckersDto.checkersGame.player.name,
    playerNb: createdCheckersDto.checkersGame.player.playerNbDto,
  },
  turnPlayer: createdCheckersDto.checkersGame.turnPlayer,
  winner: createdCheckersDto.checkersGame.winner,
  token: createdCheckersDto.token.key,
});
