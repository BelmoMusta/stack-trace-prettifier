import React, {useState} from "react";
import './style.scss';

function Line(props) {
    const [line,] = useState(props.line || {});
    return <div>

    <span>
        <span className={"package"}>{line.packageName}.</span>
        <span className={"class"}>{line.className}.</span>
        <span className={"method"}>{line.methodName} : </span>
        <span className={"number"}>{line.lineNumber}</span>

    </span>
    </div>

}

export default Line;
