// @flow
import React from 'react';
import { Link, Route } from 'react-router-dom';
import { withRouter } from 'react-router';
import CreateCheckersPage from './view/pages/CreateCheckersPage';
import CheckersGamePage from './view/pages/CheckersGamePage';
import { REDIRECT_EVENT_NAME } from './packages/events/event';

const HOME_URL = '/';
const CHECKERS_GAME_URL = '/checkers';

type Props = {
  history: any,
}

class App extends React.Component<Props> {
  componentWillMount() {
  // eslint-disable-next-line no-undef
    window.addEventListener(REDIRECT_EVENT_NAME, this.redirectToCheckersGame);
  }

  redirectToCheckersGame = (event) => {
    this.props.history.push(CHECKERS_GAME_URL);
  };

  render() {
    return (
      <div className="ia-c-app">
        <nav className="navbar navbar-dark bg-dark">
          <Link to={HOME_URL} className="navbar-brand">Iataaa</Link>
        </nav>

        <Route exact path={HOME_URL} component={CreateCheckersPage} />
        <Route path={CHECKERS_GAME_URL} component={CheckersGamePage} />
      </div>
    );
  }
}

export default withRouter(App);
