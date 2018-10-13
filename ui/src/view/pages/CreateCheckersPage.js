// @flow
import React from 'react';
import CheckersForm from '../components/CheckersForm';

class CreateCheckersPage extends React.Component<{}> {
  render() {
    return (
      <div className="ia-c-create-checkers-page">
        <div className="ia-c-create-checkers-page__container rounded">
          <h2 className="ia-c-create-checkers-page__title">Start checkers</h2>
          <CheckersForm />
        </div>
      </div>
    );
  }
}

export default CreateCheckersPage;
