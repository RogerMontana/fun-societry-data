import React from "react";
import ReactDOM from "react-dom";
import "../css/prism.css";
import $ from "jquery";
import Editor from 'react-simple-code-editor';
import { highlight, languages } from 'prismjs/components/prism-core';
import 'prismjs/components/prism-clike';
import 'prismjs/components/prism-javascript';


export default class ContainerDiv extends React.Component {
    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            code: `function add(a, b) {
  return a + b;
}
`
        };
    }

    handleSubmit(e) {
        e.preventDefault();
        let component = this;
        let searchInput = ReactDOM.findDOMNode(this.refs.search);
        $.ajax({
            url: 'http://localhost:8080/search?query=' + searchInput.value,
            dataType: 'json',
            success: function (data) {
                let parsed = data.map(e => JSON.parse(e));
                //component.setState({results: parsed});
            }
        });
        // searchInput.value = '';
    }

    render() {
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
                    <div className="row">
                        <div className="large-12 columns">
                            <Editor
                                value={this.state.code}
                                onValueChange={newCode => this.setState({code: newCode})}
                                highlight={newCode => highlight(newCode, languages.js)}
                                padding={10}
                                style={{
                                    fontFamily: '"Fira code", "Fira Mono", monospace',
                                    fontSize: 12,
                                }}
                            />
                        </div>
                    </div>
                </div>
            </form>
        </div>;
    }
}

ReactDOM.render(
    <ContainerDiv/>,
    document.getElementById('container')
);