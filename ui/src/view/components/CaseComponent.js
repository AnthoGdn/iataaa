// @flow
import React from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import type { Case } from '../../packages/flow-typed/checkers/model/type/case';
import { Cases } from '../../packages/flow-typed/checkers/model/type/case';
import { movePieceAction, setPiecePositionAction } from '../../packages/store/game/actions';
import type { GamesValuesState } from '../../packages/flow-typed/checkers/store/state/gameState';
import type { PossibleMovesState } from '../../packages/flow-typed/checkers/store/state/possibleMovesState';
import { isPossibleMoveCase } from '../../packages/utils/utils';

type Props = {
  aCase?: Case,
  nb: number,
  setPiecePositionAction: (selectedPiecePosition: number) => any,
// eslint-disable-next-line react/no-unused-prop-types
  movePieceAction: (position: number) => any,
  checkers: GamesValuesState,
  possibleMoves: PossibleMovesState,
}

class CaseComponent extends React.Component<Props> {
  onClick = (props: Props) => {
    const {
      checkers, possibleMoves, aCase, nb,
    } = props;
    if (checkers.winner) {
      return;
    }
    if (isPossibleMoveCase(nb, checkers.actualMove, possibleMoves)) {
      props.movePieceAction(props.nb);
    } else if (aCase === Cases.WHITE_PIECE || aCase === Cases.WHITE_QUEEN) {
      this.props.setPiecePositionAction(this.props.nb);
    }
  };

  render() {
    const { aCase } = this.props;
    let cssColorPiece;
    switch (aCase) {
    case Cases.WHITE_PIECE:
      cssColorPiece = '--white --piece';
      break;
    case Cases.WHITE_QUEEN:
      cssColorPiece = '--white --queen';
      break;
    case Cases.BLACK_PIECE:
      cssColorPiece = '--black --piece';
      break;
    case Cases.BLACK_QUEEN:
      cssColorPiece = '--black --queen';
      break;
    default:
      cssColorPiece = '';
      break;
    }
    const { checkers, possibleMoves } = this.props;
    let cssColorCase = 'as--black';
    if (isPossibleMoveCase(this.props.nb, checkers.actualMove, possibleMoves)) {
      cssColorCase = 'as--possible-move';
    }

    return (
      <div
        className={`ia-c-case ${cssColorCase}`}
        onClick={() => this.onClick(this.props)}
        onKeyPress={() => this.onClick(this.props)}
        role="button"
        tabIndex="0"
      >
        { aCase !== Cases.EMPTY && <div className={`ia-c-case__piece ${cssColorPiece}`} />}
      </div>
    );
  }
}

const mapStateToProps = state => ({
  checkers: state.game.values,
  possibleMoves: state.possibleMoves,
});

const mapDispatchToProps = dispatch => bindActionCreators({
  setPiecePositionAction, movePieceAction,
}, dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(CaseComponent);
