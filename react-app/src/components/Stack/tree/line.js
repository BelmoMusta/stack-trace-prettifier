import React, {useState} from "react";
import './style.scss';

function Line(props) {
    const [line,] = useState(props.line || {});
    return <span>
        <span className={"yellow"}>{line.packageName}.</span>
        <span className={"blue"}>{line.fileName}</span>
    </span>

}

export default Line;
