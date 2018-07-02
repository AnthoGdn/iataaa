// @flow
import React from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { createGameAction } from '../../packages/store/game/actions';
import { GameState } from '../../packages/flow-typed/checkers/store/state/gameState';

type Props = {
  createCheckersAction: (string, string) => void,
  checkers: GameState,
}

type State = {
  checkersName: string,
  playerName: string,
}

class CheckersForm extends React.Component<Props, State> {
  state = {
    checkersName: '',
    playerName: '',
  };

  createGame = (event) => {
    event.preventDefault();
    const { checkersName, playerName } = this.state;
    this.props.createCheckersAction(checkersName, playerName);
  };

  checkersNameOnChange = (event) => {
    this.setState({
      checkersName: event.target.value,
    });
  };

  playerNameOnChange = (event) => {
    this.setState({
      playerName: event.target.value,
    });
  };

  isValidForm = () => this.state.checkersName.length > 0 && this.state.playerName.length > 0;

  render() {
    const { checkersName, playerName } = this.state;
    const { isLoading } = this.props.checkers;
    return (
      <form onSubmit={this.createGame}>

        <div className="form-group">
          <label htmlFor="checkers-name">
            Checkers name
            <input
              id="checkers-name"
              className="form-control"
              placeholder="Enter checkers name"
              type="text"
              onChange={this.checkersNameOnChange}
              value={checkersName}
              required
            />
          </label>
        </div>
        <div className="form-group">
          <label htmlFor="player-name">
            Player name
            <input
              id="player-name"
              className="form-control"
              placeholder="Enter your name"
              type="text"
              onChange={this.playerNameOnChange}
              value={playerName}
              required
            />
          </label>
        </div>
        <div className="ia-c-checkers-form__submit-container">
          <button
            type="submit"
            className={`btn btn-primary ${!this.isValidForm() ? 'disabled' : ''} ${isLoading ? 'as--loading' : ''}`}
          >
            Start checkers
          </button>
        </div>
      </form>
    );
  }
}
const mapStateToProps = state => ({
  checkers: state.game,
});

const mapDispatchToProps = dispatch => bindActionCreators({
  createCheckersAction: createGameAction,
}, dispatch);


export default connect(mapStateToProps, mapDispatchToProps)(CheckersForm);
