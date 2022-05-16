import React, { useState, useEffect, useRef, useContext } from 'react';
import MenuContext from '../../contexts/MenuContext/MenuContext';

//Components imports
import { Dialog } from 'primereact/dialog';
import { Toast } from 'primereact/toast';
import { Button } from 'primereact/button';

import "../cssFiles/FormDemo.css";

export default function DeleteOneUser() {
    const { emergentDeleteOneUserState } = useContext(MenuContext);
    const menuContext = useContext(MenuContext);

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

    const deleteProductDialogFooter = (
        <>
          <Button label="No" icon="pi pi-times" className="p-button-text" onClick={onHide} />
          <Button label="Si" icon="pi pi-check" className="p-button-text" onClick={onHide} />
        </>
      );
    return (
        <div className="flex flex-col">
            <Toast ref={toast} />
            <Dialog 
                visible={display} style={{ width: '450px' }} 
                header="Confirm" 
                modal 
                footer={deleteProductDialogFooter} 
                onHide={() => onHide('display')}
            >
                <div className="confirmation-content">
                    <i className="pi pi-exclamation-triangle mr-3" style={{ fontSize: '2rem' }} />
                    {menuContext.userCode && <span>¿Seguro que desea eliminar el usuario <b>{menuContext.userCode}</b>?</span>}
                </div>
            </Dialog>
        </div>
    )
}
