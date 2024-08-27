// 

import React, { Component } from "react";

class ApiEx extends Component {
  state = {
    data: [],
  };

  componentDidMount() {
    // const url =
    //   ``;
    // fetch(url)
    //   .then((result) => result.json())
    //   .then((res) => {
    //     this.setState({ data: res });
    //   })
    //   .catch((error) => console.error("Error fetching data:", error));

    fetch('https://jsonplaceholder.typicode.com/posts', {
        method: 'POST',
        body: JSON.stringify({
          title: 'foo',
          body: 'bar',
          userId: 1,
        }),
        headers: {
          'Content-type': 'application/json; charset=UTF-8',
        },
      })
        .then((response) => response.json())
        .then((json) => {
            this.setState({data:json})
        });
  }

  render() {
    const list = this.state.data.map((val, index) => {
      return <li key={index}>{val}</li>;
    });

    return (
      <>
        <h1>API Fetch</h1>
        <ul>{list}</ul>
      </>
    );
  }
}

export default ApiEx;
