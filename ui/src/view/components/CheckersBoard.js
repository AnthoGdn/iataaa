// @flow
import React from 'react';
import { connect } from 'react-redux';
import CaseRowComponent from './CaseRowComponent';
import type { CheckersBoard } from '../../packages/flow-typed/checkers/model/type/checkersBoard';
import type { Case } from '../../packages/flow-typed/checkers/model/type/case';

type Props = {
  checkersBoard: CheckersBoard,
}

const mapCheckersBoardToArraysView = (checkersBoard: CheckersBoard): Array<Case[]> => {
  const result: Array<Case[]> = [];
  for (let i = 0; i < 10; i += 1) {
    result.push(checkersBoard.slice(45 - (i * 5), 50 - (i * 5)));
  }
  return result;
};

class CheckersBoardComponent extends React.Component<Props> {
  render() {
    const { checkersBoard } = this.props;
    const rows = mapCheckersBoardToArraysView(checkersBoard);
    return (
      <div className="ia-c-checkers-board">
        {
          rows.map((row, key) => <CaseRowComponent key={key} rowNb={key} row={row} />)
        }
      </div>
    );
  }
}

const mapStateToProps = state => ({
  checkersBoard: state.game.values.actualMove.board,
});

export default connect(mapStateToProps)(CheckersBoardComponent);


// TODO: inform user when he takes mistake
// TODO: add message when user win or loose
