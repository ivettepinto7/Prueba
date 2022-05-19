import React, { useState } from 'react';

import MenuContext from './MenuContext';

const MenuState = (props) => {
    //State for create new user window
    const [emergentNewUserState, setEmergentNewUserState] = useState(false);

    //State for edit user window
    const [emergentEditUserState, setEmergentEditUserState] = useState(false);

    //State for delete MANY users window
    const [emergentDeleteOneUserState, setEmergentDeleteOneUserState] = useState(false);

    //State for create new exam
    const [emergentNewExamState, setEmergentNewExamState] = useState(false);

    //User code storage
    const [userCode, setUserCode] = useState("");

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

    //Function for emergent delete one user state
    function settingEmergentNewExamState() {
        if (emergentNewExamState) setEmergentNewExamState(false);
        else setEmergentNewExamState(true);
    }
    

    //Function to save user code used in emergent edit user
    function settingUserCode(code){
        setUserCode(code);
    }

    return (
        <MenuContext.Provider
            value={{
                emergentNewUserState,
                emergentEditUserState,
                emergentDeleteOneUserState,
                emergentNewExamState,
                userCode,

                settingEmergentNewUserState,
                settingEmergentEditUserState,
                settingEmergentDeleteOneUserState,
                settingEmergentNewExamState,
                settingUserCode,
            }}
        >
            { props.children }
        </MenuContext.Provider>
    )
}

export default MenuState;