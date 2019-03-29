import React from 'react';

export default class Card extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return <div className="panel callout radius">
      <h4>Language: {this.props.info["Name"]}</h4>
      <h4>Type: {this.props.info["Type"]}</h4>
      <h4>Designed by: {this.props.info["Designed by"]}</h4>
    </div>;
  }
}


