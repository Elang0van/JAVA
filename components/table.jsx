import { Component } from "react";

function TableHeader() {
    return (
        <thead>
            <tr>
                <th>Name</th>
                <th>Job</th>
                <th>Phone</th>
                <td>Experience</td>
                <td>Address</td>
                <th>Action</th>
            </tr>
        </thead>
    );
}

function TableBody(props) {
    const { charData, removeChar } = props;

    const rows = charData.map((c, index) => {
        return (
            <tr key={index}>
                <td>{c.name}</td>
                <td>{c.job}</td>
                <td>{c.phone}</td>
                <td>wait</td>
                <td><button onClick={() => removeChar(index)}>Delete</button></td>
            </tr>
        );
    });

    return <tbody>{rows}</tbody>;
}

class Table extends Component {
    render() {
        const { charData, removeChar } = this.props;
        return (
            <table>
                <TableHeader />
                <TableBody charData={charData} removeChar={removeChar} />
            </table>
        );
    }
}

export default Table;
