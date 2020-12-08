import React, {useState} from 'react';

import Tree from 'react-animated-tree'


 function Prolog(props) {
    const [prolog, ] = useState(props.prolog || {})

     return <Tree type="" content={<span className="text-wrap">{prolog.description}</span>}>
        {prolog.prolog && <span> <Prolog prolog={prolog.prolog}/></span>}
    </Tree>

}
export default Prolog
