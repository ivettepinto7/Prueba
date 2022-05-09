import React, { useState } from 'react'

//Icons imports
import { FontAwesomeIcon as Icon } from '@fortawesome/react-fontawesome';
import { faCircleUser } from '@fortawesome/free-solid-svg-icons';

//Components imports
import { Sidebar } from 'primereact/sidebar';
import { PanelMenu } from 'primereact/panelmenu';

import logo from '../logo.png';
import { Routes } from '../helpers/Routes';
import "./cssFiles/PanelMenu.css";

export default function SideBar() {
    const [active, setActive] = useState(false) // Prueba de ocultamiento de opciones

    return (
        <div className='w-full p-4 flex items-center justify-between bg-blue-800'>
            <button onClick={() => setActive(true)} className=" p-sidebar-icon p-link mr-1">
                <span style={{ color: 'white', 'fontSize': '2em' }} className="pi pi-bars" />
            </button>
            <h1 className='lg:text-4xl sm:text-3xl text-white'>Holistic Hospital</h1>
            <img src={logo} alt='logo' className='mr-2' style={{ height: '10vmin' }} />
            <Sidebar visible={active} onHide={() => setActive(false)} style={{ color: 'white', backgroundColor: 'black' }}>
                <div className="w-full flex flex-row">
                    <Icon icon={faCircleUser} className="text-4xl m-2 text-white" />
                    <div className="flex flex-row justify-between w-full items-center m-2">
                        <h1 className="text-bold">Usuario X</h1>
                        <h1 className="text-red-500">Cerrar sesión</h1>
                    </div>
                </div>
                <ul className="w-full text-white lg:mt-4">
                    <PanelMenu model={Routes} />
                </ul>
            </Sidebar>
        </div>
    )
}