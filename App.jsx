import React, { Component } from "react";
import Table from "./components/table";
import Form from "./components/form";
import ApiEx from "./components/apiEx";

class App extends Component {
    state = {
        charData: [
            { name: "Elango", job: 'Developer' },
            { name: "Panneer", job: 'Farmer' },
            { name: "Arun", job: 'Driver' },
            { name: "Shot", job: 'Teacher' },
            { name: "Ace", job: 'Pirate' }
        ],
    }

    removeChar = (index) => {
        const { charData } = this.state;
        const filteredData = charData.filter((c, i) => i !== index);
        this.setState({ charData: filteredData });
    }

    handleSubmit = (newChar) => {
        this.setState({
            charData: [...this.state.charData, newChar],
        });
    }

    render() {
        const { charData } = this.state;
        return (
            <div>
                <h1>Table</h1>
                 <Table charData={charData} removeChar={this.removeChar} />
            
                <Form handleSubmit={this.handleSubmit} />
                <ApiEx/>
            </div>
        );
    }
}

export default App;



