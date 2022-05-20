import React, { useState, useEffect, useRef, useContext } from 'react';
import MenuContext from '../../contexts/MenuContext/MenuContext';
import { UserContext } from '../../contexts/UserContext/UserContext';

//Components imports
import { Dialog } from 'primereact/dialog';
import { Toast } from 'primereact/toast';
import { Button } from 'primereact/button';

import "../cssFiles/FormDemo.css";

export default function DeleteOneUser() {
    const { emergentDeleteOneUserState } = useContext(MenuContext);
    const menuContext = useContext(MenuContext);
    const userContext = useContext(UserContext);

    const toast = useRef(null);

    const [display, setDisplay] = useState(false);

    useEffect(() => {
        setDisplay(emergentDeleteOneUserState);
    }, [emergentDeleteOneUserState]);

    /**
* Upload New User Emergent logic section code
*/
    const dialogFuncMap = {
        display: setDisplay,
    };

    const onHide = (name) => {
        menuContext.settingEmergentDeleteOneUserState();
        dialogFuncMap[`${name}`](false);
    };

    const deleteOneUserDialogFooter = (
        <>
          <Button label="No" icon="pi pi-times" className="p-button-text" onClick={() => onHide("display")} />
          <Button label="Si" icon="pi pi-check" className="p-button-text" onClick={() => onHide("display")} />
        </>
      );
    return (
        <div className="flex flex-col">
            <Toast ref={toast} />
            <Dialog 
                visible={display} style={{ width: '450px' }} 
                header="Confirm" 
                modal 
                footer={deleteOneUserDialogFooter} 
                onHide={() => onHide('display')}
            >
                <div className="confirmation-content">
                    <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                    {userContext.userCode && <span>¿Seguro que desea eliminar el usuario <b>{userContext.userCode}</b>?</span>}
                </div>
            </Dialog>
        </div>
    )
}
