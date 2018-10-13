// @flow
import React from 'react';
import CaseComponent from './CaseComponent';
import EmptyCaseComponent from './EmptyCaseComponent';

const computeIndex = (row, i) => (45 - (row * 5)) + i;
const isPair = (n: number): boolean => n % 2 === 0;

const isBlack = (row: number) => !isPair(row);

class CaseRowComponent extends React.Component<{rowNb: number, row: any}> {
  render() {
    const { rowNb, row } = this.props;
    return (
      <div className="ia-c-case-row">
        {
          row.map((c, key) => {
            if (isBlack(rowNb)) {
              return (
                <React.Fragment key={key}>
                  <div className="ia-c-case-row__item">
                    <CaseComponent aCase={c} nb={computeIndex(rowNb, key)} />
                  </div>
                  <div className="ia-c-case-row__item">
                    <EmptyCaseComponent />
                  </div>
                </React.Fragment>
              );
            }
            return (
              <React.Fragment key={key}>
                <div className="ia-c-case-row__item">
                  <EmptyCaseComponent />
                </div>
                <div className="ia-c-case-row__item">
                  <CaseComponent aCase={c} nb={computeIndex(rowNb, key)} />
                </div>
              </React.Fragment>
            );
          })
        }
      </div>
    );
  }
}

export default CaseRowComponent;
