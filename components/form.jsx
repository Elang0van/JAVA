import React, { Component } from "react";

import "./form.css";

class Form extends Component {
    initialState = {
        name:"",
        job:"",
        phone:isNaN?"":0,
    }

    state = this.initialState;

    handleChange = (event) => {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    submitHandler = (event) => {
        event.preventDefault();
        console.log("submitted");
        this.setState(this.initialState);
        let character = this.state;
        this.props.handleSubmit(character);
      
    }

    render() {
        return (<div>
            <form>
                <label htmlFor="name">Name</label>
                <input
                    type="text"
                    name="name"
                    id="name"
                    value={this.state.name}
                    onChange={this.handleChange}
                /><br/>

                <label htmlFor="job">Job</label>
                <input
                    type="text"
                    name="job"
                    id="job"
                    value={this.state.job}
                    onChange={this.handleChange}
                /><br/>

                <label htmlFor="">
                   phone <br /><input type="phone" 
                    name="phone" 
                    value={this.state.phone}
                     onChange={this.handleChange}/>
                </label><br />

                <input
                    type="button"
                    value="Submit"
                    onClick={this.submitHandler}
                />
            </form>
            </div>
        );
    }
}

export default Form;
