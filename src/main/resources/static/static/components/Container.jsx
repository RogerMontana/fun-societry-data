import React from 'react';
import ReactDOM from 'react-dom';

import Card from './Card.jsx';
import $ from 'jquery';

export default class ContainerDiv extends React.Component{
  constructor(props) {
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.state = {
      results: []
    };
  }

  handleSubmit(e) {
    e.preventDefault();
    let component = this;
    let searchInput = ReactDOM.findDOMNode(this.refs.search);
    $.ajax({
      url: 'http://127.0.0.1:8087/search?query=' + searchInput.value,
      dataType: 'json',
      success: function(data){
        let parsed = data.map(e=>JSON.parse(e));
        component.setState({results: parsed});
      }
    });
    // searchInput.value = '';
  }

  render() {
    let cardId = 1;
    let cards = this.state.results.map(result => <Card key = {cardId++} info={result} />);
    return <div className="row">
      <h3>Search by Json File</h3>
      <form onSubmit={this.handleSubmit}>
        <div className="row">
          <div className="small-10 columns">
            <input type="text" placeholder="search" ref="search"/>
          </div>
          <div className="small-2 columns">
            <button className="hollow button">SEARCH</button>
          </div>
        </div>
      </form>
      <div>
        {cards}
      </div>
    </div>;
  }
}

ReactDOM.render(
  <ContainerDiv/>,
  document.getElementById('container')
);