const board = ['WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE', 'WHITE_QUEEN', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE'];

export const complexGameValues = {
  id: 'ede710ee-748e-45ef-a155-bbaa6d4ac616',
  name: 'Antho vs ai',
  board,
  actualMove: {
    board,
    selectedPiecePosition: 45,
    size: 0,
  },
  player: {
    id: '9dc04162-fdd2-4d2f-bbec-a4c7687e7307',
    name: 'Anthony',
    playerNb: 'PLAYER_1',
  },
  turnPlayer: 'PLAYER_1',
  winner: null,
  token: '1b6ee369-4408-491c-a42e-341a88c7c9ef',
};

export const complexPossibleMoves = {
  values: [
    [
      ['WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'WHITE_QUEEN', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE'], ['WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'WHITE_PIECE', 'EMPTY', 'EMPTY', 'WHITE_QUEEN', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE', 'EMPTY', 'EMPTY', 'EMPTY', 'EMPTY', 'BLACK_PIECE'],
    ],
  ],
  isLoading: false,
  error: null,
};
