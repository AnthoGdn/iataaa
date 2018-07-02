const gameInitialState = {
  values: {
    id: '',
    name: '',
    board: [],
    actualMove: {
      board: [
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'WHITE_PIECE',
        'EMPTY',
        'EMPTY',
        'EMPTY',
        'EMPTY',
        'EMPTY',
        'EMPTY',
        'EMPTY',
        'EMPTY',
        'EMPTY',
        'EMPTY',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
        'BLACK_PIECE',
      ],
      selectedPiecePosition: null,
      size: 0,
    },
    player: {
      id: '',
      name: 'Anthony',
      playerNb: 'PLAYER_1',
    },
    turnPlayer: 'PLAYER_1',
    winner: null,
    token: '',
  },
  isLoading: false,
  error: null,
};

export default gameInitialState;
