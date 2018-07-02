// @flow
import React from 'react';
import type { PlayerNb } from '../../../packages/flow-typed/checkers/model/type/player';
import { PLAYER_1 } from '../../../packages/contants/constants';
import Loader from './Loader';

type Props = {
  playerName: string,
  playerNb: PlayerNb,
  isYou: boolean,
  pieceNb: number,
  queenNb: number,
  turnPlayer: string,
  winner: ?PlayerNb,
};

class CheckersPlayerBoard extends React.Component<Props> {
  renderInfo = () => {
    const { turnPlayer, playerNb, winner } = this.props;

    if (playerNb === PLAYER_1) {
      if (!winner) {
        if (turnPlayer === PLAYER_1) {
          return (
            <div className="badge badge-success as--md">
                It is your turn !
            </div>
          );
        }
        return (
          <div className="badge badge-warning as--md">
            <Loader />
            {' '}
            Please wait computer turn.
          </div>
        );
      }
      if (winner === PLAYER_1) {
        return (
          <div className="badge badge-success as--md">
             You win !
          </div>
        );
      }
      return (
        <div className="badge badge-danger as--md">
            You loose.
        </div>
      );
    }

    return '';
  };

  render() {
    const {
      playerName, isYou, pieceNb, queenNb,
    } = this.props;
    return (
      <div className="ia-c-player-board rounded">
        <div className="ia-c-player-board__card-content">
          <div>
            <span>{playerName}</span>
            { isYou && <span className="badge badge-primary ml-1">you</span> }
          </div>

          <div>
            Pieces:
            {' '}
            { pieceNb }
          </div>
          <div>
            Queens:
            {' '}
            { queenNb }
          </div>
          <div>
            Total:
            {' '}
            { pieceNb + queenNb }
          </div>
          {
            this.renderInfo()
          }
        </div>
      </div>
    );
  }
}

export default CheckersPlayerBoard;
