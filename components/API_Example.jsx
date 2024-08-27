import { Component } from "react";

class ApiE extends Component{

    state={
        data:["First item","second item"]
    }
    render(){
        const list=this.state.data.map((value,index)=>{
            return <li key={index}>{value}</li>
            
        })
        return(
            <ul>
               {list}
            </ul>
        )
    }
}

export default ApiE;