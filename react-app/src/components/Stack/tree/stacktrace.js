import React from "react";
import Prolog from "./prolog";
import Tree from "react-animated-tree";
import Line from "./line";

function StackTrace(props) {
    const {trace} = props;

    return (<span>
            {trace.prolog && <Prolog prolog={trace.prolog}/>}
            {trace.stackTraceLines &&

            <Tree style={{ color: "#f83737" }}
                  content={<span className={"package"}>{trace.stackTraceLines.length + " LINES"}
            </span>}>
                {(trace.stackTraceLines.map(l =>
                    <Line line={l}/>
                ))}</Tree>}


            {trace.causedBy &&
            <Tree content={<span className={"package"}>CAUSED BY</span>}> <StackTrace trace={trace.causedBy}/></Tree>}
        </span>
    );

}

export default StackTrace;
