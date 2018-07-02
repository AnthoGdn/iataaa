// @flow
import type { PossibleMovesState } from '../../flow-typed/checkers/store/state/possibleMovesState';

export const possibleMovesInitialState: PossibleMovesState = {
  values: null,
  isLoading: false,
  error: null,
};

export default possibleMovesInitialState;
