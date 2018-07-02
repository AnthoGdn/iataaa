// @flow
import React from 'react';
import { connect } from 'react-redux';
import CheckersPlayerBoard from '../components/generic-components/CheckersPlayerBoard';
import type { Checkers } from '../../packages/flow-typed/checkers/model/checkers';
import CheckersBoardComponent from '../components/CheckersBoard';
import { Cases } from '../../packages/flow-typed/checkers/model/type/case';
import { getPieceNb } from '../../packages/utils/utils';
import { PLAYER_1, PLAYER_2 } from '../../packages/contants/constants';

type Props = {
  checkers: Checkers,
};

class CheckersGamePage extends React.Component<Props> {
  render() {
    const { checkers } = this.props;
    const { actualMove } = checkers;
    return (
      <div className="ia-c-checkers">
        <div className="ia-c-checkers__item ia-c-checkers__panel">
          <CheckersPlayerBoard
            playerName={checkers.player.name}
            playerNb={PLAYER_1}
            isYou
            pieceNb={getPieceNb(actualMove.board || [], Cases.WHITE_PIECE)}
            queenNb={getPieceNb(actualMove.board || [], Cases.WHITE_QUEEN)}
            turnPlayer={checkers.turnPlayer}
            winner={checkers.winner}
          />
        </div>
        <div className="ia-c-checkers__item ia-c-checkers__board">
          <CheckersBoardComponent />
        </div>
        <div className="ia-c-checkers__item ia-c-checkers__panel">
          <CheckersPlayerBoard
            playerName="Computer"
            playerNb={PLAYER_2}
            isYou={false}
            pieceNb={getPieceNb(actualMove.board || [], Cases.BLACK_PIECE)}
            queenNb={getPieceNb(actualMove.board || [], Cases.BLACK_QUEEN)}
            turnPlayer={checkers.turnPlayer}
            winner={checkers.winner}
          />
        </div>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  checkers: state.game.values,
});

export default connect(mapStateToProps)(CheckersGamePage);
