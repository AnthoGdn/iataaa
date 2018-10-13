export const mapPossibleMovesResponseDtoToPossibleMove = possibleMovesResponseDto => (
  possibleMovesResponseDto.possibleMoves.map(
    possibleMoveDto => possibleMoveDto.map(
      casesDto => casesDto.cases
    )
  )
);
