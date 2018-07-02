// @flow

import type { GameState } from '../flow-typed/checkers/store/state/gameState';
import type { PossibleMovesState } from '../flow-typed/checkers/store/state/possibleMovesState';

export type State = {
    game: GameState,
    possibleMoves: PossibleMovesState,
}
