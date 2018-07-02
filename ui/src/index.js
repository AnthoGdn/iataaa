import React from 'react';
import ReactDOM from 'react-dom';
import { applyMiddleware, combineReducers, createStore } from 'redux';
import { Provider } from 'react-redux';
import thunk from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension';
import { BrowserRouter as Router } from 'react-router-dom';

import './packages/scss/index.css';
import gameReducers from './packages/store/game/reducers';
import possibleMoveReducers from './packages/store/possibleMoves/reducers';

import gameInitialState from './packages/store/game/state';
import possibleMovesInitialState from './packages/store/possibleMoves/state';

import App from './App';
import registerServiceWorker from './registerServiceWorker';

const reducers = combineReducers({
  game: gameReducers,
  possibleMoves: possibleMoveReducers,
});

const initialState = {
  game: gameInitialState,
  possibleMoves: possibleMovesInitialState,
};

const store = createStore(
  reducers,
  initialState,
  composeWithDevTools({
    serialize: true,
    name: 'iataaa',
  })(applyMiddleware(thunk))
);

// eslint-disable-next-line no-undef
ReactDOM.render(
  <Provider store={store}>
    <Router>
      <App />
    </Router>
  </Provider>,
  // eslint-disable-next-line no-undef
  document.getElementById('root')
);
registerServiceWorker();
