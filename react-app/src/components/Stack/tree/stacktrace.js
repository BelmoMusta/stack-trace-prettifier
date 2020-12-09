import React from "react";
import Prolog from "./prolog";
import Tree from "react-animated-tree";
import Line from "./line";
import Method from "./method";

function StackTrace(props) {
    const {trace} = props;

    return (<span>
            {trace.prolog && <Prolog prolog={trace.prolog}/>}
            {trace.stackTraceLines &&
            <Tree content={trace.stackTraceLines.length + "  LINES"}>{(trace.stackTraceLines.map(l =>
                <Tree type="" content={<Line line={l}/>}>
                   <Method method={{ name: l.methodName, lineNumber: l.lineNumber}}/>
                </Tree>
            ))}</Tree>}

            {trace.importantLines &&
            <Tree content={trace.importantLines.length + "  IMPORTANT LINES"}>{(trace.importantLines.map(l =>
                <Tree type="" content={<Line line={l}/>}>
                   <Method method={{ name: l.methodName, lineNumber: l.lineNumber}}/>
                </Tree>
            ))}</Tree>}

            {trace.causedBy && <Tree content={"CAUSED BY"}> <StackTrace trace={trace.causedBy}/></Tree>}
        </span>
    );

}

export default StackTrace;
