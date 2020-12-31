import React, {useState} from 'react';
import './style.scss';
import Tree from "react-animated-tree";
import StackTrace from "./stacktrace";
import {post} from '../../../restService/restApiCaller';
import st from '../../../data/stack'
import {dark} from "@material-ui/core/styles/createPalette";


export default function FileSystemNavigator(props) {
    const [stacks, setStacks] = useState(st);
    const [input, setInput] = useState({});
    const [filter, setFilter] = useState("");

    const config = open => ({
        from: {height: 0, opacity: 0, transform: 'translate3d(20px,0,0)'},
        to: {
            height: open ? 'auto' : 0,
            opacity: open ? 1 : 0,
            transform: open ? 'translate3d(0px,0,0)' : 'translate3d(20px,0,0)',
        },
    })

    function callApi() {
        post(input.value,
            (data) => {
                setStacks({});
                setStacks(data);
            });
    }

    const handleChange = function (event) {
        setInput({value: event.target.value});
    };

    const handleFilter = function (event) {
        setFilter(event.target.value);
    };

    function filterTree() {
        setStacks({...stacks, stackTraceLines: stacks.stackTraceLines.filter(line => line.packageName.includes(filter))});

    }

    return  <span >
        Convert a java stack trace into a readable tree view
              <div>
                    <div className="d-md-flex h-md-100 align-items-center scrollable">
                    <div className="col-md-6 p-0 bg-indigo h-md-100 hidden">
                        <div
                            className="text-white d-md-flex_ align-items-center_ h-100_ p-3 text-center_ justify-content-center_">
                            <div className="pt-5 pb-5">
                                     <textarea
                                         value={input.value}
                                         onChange={handleChange}
                                         rows={20} id="stackTrace" className={"textarea"}/>
                                     <button className={"pull-right"} onClick={callApi}> Prettify </button>
                            </div>
                        </div>
                    </div>
                <div className="scol-md-6 p-0  hf-md-100 scrollable" className={"dark-background"}>
                    <div className={"filter"}>
                      <input type="text" placeholder="filter by package / or class name" className="form-control"
                      onChange={handleFilter}
                      />
                      <button onClick={filterTree}> filter </button>
                    </div>
                    <div className="ds-md-flex_ hs-md-100 ps-4">
                        <Tree open={false} canHide visible content="Stack trace" springConfig={config}>
                            <StackTrace trace={stacks}/>
                        </Tree>
                    </div>
                </div>
          </div>
              </div>
    </span>
}
