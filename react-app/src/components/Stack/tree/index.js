import React, {useState} from 'react';
import './style.scss';
import Tree from "react-animated-tree";
import StackTrace from "./stacktrace";
import {post} from '../../../restService/restApiCaller';
import st from '../../../data/stack'


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
        post({rawStackTrace :input.value, filter},
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
       callApi();

    }

    return <span>
    <div>
        <div className="d-md-flex h-md-50 align-items-center scrollable">
            <div className="col-md-3 p-0 bg-indigo h-md-100">
                <div>
                    <textarea value={input.value} onChange={handleChange} rows={20}
                              id="stackTrace" className={"textarea"}/>
                        <button className={"prettify-button"} onClick={callApi}>Prettify</button>
                </div>
            </div>
            <div className="col-md-9 p-0  h-md-100 scrollable dark-background">
                <div className="filter col-md-6">
                    <div className={"input-group mb-3"}>
                    <input type="text" placeholder="filter by package / or class name"
                           className="form-control"
                           onChange={handleFilter}/>
                    <div className={"input-group-prepend"}>
                        <button onClick={filterTree} className={"btn btn-primary"}> filter </button>
                    </div>
                </div>
            </div>
            <div className="d-md-flex p-4">
                <Tree open visible content="Stack trace" springConfig={config}>
                    <StackTrace trace={stacks}/>
                </Tree>
            </div>
        </div>
    </div>
    </div>
</span>

}
