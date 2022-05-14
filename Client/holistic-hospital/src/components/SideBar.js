import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

//Icons imports

//Components imports
import { Sidebar } from 'primereact/sidebar';
import { PanelMenu } from 'primereact/panelmenu';

//Resources imports
import logo from '../logo.png';
import { convertRoutes } from '../helpers/Routes';
import "./cssFiles/PanelMenu.css";

export default function SideBar() {
    const navigate = useNavigate();
    const [active, setActive] = useState(false) // Prueba de ocultamiento de opciones

    return (
        <div className='w-full p-4 flex items-center justify-between bg-blue-800'>
            <button onClick={() => setActive(true)} className=" p-sidebar-icon p-link mr-1">
                <span style={{ color: 'white', 'fontSize': '2em' }} className="pi pi-bars" />
            </button>
            <h1 className='lg:text-4xl sm:text-3xl text-white'>Holistic Hospital</h1>
            <img src={logo} alt='logo' className='mr-2' style={{ height: '10vmin' }} />
            <Sidebar visible={active} onHide={() => setActive(false)} style={{ color: 'white', backgroundColor: 'black' }}>
                <div className="w-full flex flex-row items-center">
                    <img src={logo} alt='logo' className='mr-2' style={{ height: '10vmin' }} />
                    <h1 className="text-bold text-center w-full">¡ Bienvenid@ Usuario X !</h1>
                </div>
                <h1 className="text-red-500 text-center mt-2">Cerrar sesión</h1>
                <ul className="w-full text-white lg:mt-4">
                    <PanelMenu model={convertRoutes(navigate)} />
                </ul>
            </Sidebar>
        </div>
    )
}