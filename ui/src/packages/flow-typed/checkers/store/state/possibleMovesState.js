// @flow
import type { PossibleMoves } from '../../dto/checkersMoveDto';

export type PossibleMovesState = $ReadOnly<{|
  values: ?PossibleMoves,
  isLoading: boolean,
  error: ?string
|}>
