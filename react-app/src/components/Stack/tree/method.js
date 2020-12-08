import React, {useState} from "react";
import './style.scss';

function Method(props) {
    const [method,] = useState(props.method || {});
    return  <span className={"alert-primary"}>{method.name}:{method.lineNumber}</span>

}

export default Method;
