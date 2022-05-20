import React, { useState } from 'react';

import MenuContext from './MenuContext';

const MenuState = (props) => {
    //State for create new user window
    const [emergentNewUserState, setEmergentNewUserState] = useState(false);

    //State for edit user window
    const [emergentEditUserState, setEmergentEditUserState] = useState(false);

    //State for delete One users window
    const [emergentDeleteOneUserState, setEmergentDeleteOneUserState] = useState(false);

    //State for create new exam
    const [emergentNewExamState, setEmergentNewExamState] = useState(false);
    //State for edit  exam
    const [emergentEditExamState, setEmergentEditExamState] = useState(false);
    //State for delete one exam window
    const [emergentDeleteOneExamState, setEmergentDeleteOneExamState] = useState(false);


    //Function for emergent new user state
    function settingEmergentNewUserState() {
        if (emergentNewUserState) setEmergentNewUserState(false);
        else setEmergentNewUserState(true);
    }

    //Function for emergent edit user state
    function settingEmergentEditUserState() {
        if (emergentEditUserState) setEmergentEditUserState(false);
        else setEmergentEditUserState(true);
    }

    //Function for emergent delete one user state
    function settingEmergentDeleteOneUserState() {
        if (emergentDeleteOneUserState) setEmergentDeleteOneUserState(false);
        else setEmergentDeleteOneUserState(true);
    }

    //Function for emergent new exam xistence state
    function settingEmergentNewExamState() {
        if (emergentNewExamState) setEmergentNewExamState(false);
        else setEmergentNewExamState(true);
    }

    //Function for emergent edit exam xistence state
    function settingEmergentEditExamState() {
        if (emergentEditExamState) setEmergentEditExamState(false);
        else setEmergentEditExamState(true);
    }

    //Function for emergent delete one exam state
    function settingEmergentDeleteOneExamState() {
        if (emergentDeleteOneExamState) setEmergentDeleteOneExamState(false);
        else setEmergentDeleteOneExamState(true);
    }
    


    return (
        <MenuContext.Provider
            value={{
                emergentNewUserState,
                emergentEditUserState,
                emergentDeleteOneUserState,
                emergentNewExamState,
                emergentEditExamState,
                emergentDeleteOneExamState,

                settingEmergentNewUserState,
                settingEmergentEditUserState,
                settingEmergentDeleteOneUserState,
                settingEmergentNewExamState,
                settingEmergentEditExamState,
                settingEmergentDeleteOneExamState,
            }}
        >
            { props.children }
        </MenuContext.Provider>
    )
}

export default MenuState;