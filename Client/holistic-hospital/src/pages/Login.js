import React, { useState } from 'react';

//Components imports
import { InputText } from 'primereact/inputtext';
import { Password } from 'primereact/password';

import logo from'../logo.png';

export default function Login() {
    const [userCode, setUserCode] = useState("");//For input in login form
    const [password, setPassword] = useState("");//For input in login form

    return (
        <div>
            <div className="relative min-h-screen  grid bg-black ">
                <div className="flex flex-col sm:flex-row items-center md:items-start sm:justify-center md:justify-start flex-auto min-w-0 ">
                    <div
                        className="relative sm:w-1/2 xl:w-3/5 bg-blue-800 h-full hidden md:flex flex-auto items-center justify-center p-10 overflow-hidden  text-white bg-no-repeat bg-cover relative" style={{ backgroundPosition: 'center', backgroundSize: '40vmin', backgroundImage: `url(${logo})` }}>
                        <div className="absolute bg-black  opacity-25 inset-0 z-0"></div>
                    </div>
                    <div
                        className="md:flex md:items-center md:justify-left w-full sm:w-auto md:h-full xl:w-1/2 p-8  md:p-10 lg:p-14 sm:rounded-lg md:rounded-none "
                    >
                        <div className="max-w-xl w-full space-y-12">
                            <div className="lg:text-left text-center">
                                <h2 className="font-bold text-gray-100">
                                    <img src={logo} alt='logo' style={{ height: '10vmin' }} />
                                </h2>
                                <h2 className="mt-2 text-7xl font-bold text-gray-100">
                                    Holistic Hospital
                                </h2>
                            </div>
                            <div className="flex flex-row justify-center items-center space-x-2"></div>

                            <form action="/landing" className="flex flex-col block justify-center items-center p-5 w-full h-3/4 rounded-md shadow-md">
                                <span className="p-float-label">
                                    <InputText
                                        id="usercode"
                                        value={userCode}
                                        onChange={(e) => setUserCode(e.target.value)}
                                    />
                                    <label htmlFor="usercode">Código de usuario</label>
                                </span>
                                <Password
                                    autoComplete='current'
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                    feedback={false}
                                    toggleMask
                                    className="my-2"
                                />
                                <div className="flex flex-row justify-center w-full">
                                    <button
                                        type="submit"
                                        className="lg:w-1/2 w-full flex justify-center text-white p-2 rounded-full tracking-wide font-bold focus:outline-none focus:shadow-outline hover:bg-indigo-600 shadow-lg bg-blue-800 cursor-pointer transition ease-in duration-300"
                                    >
                                        Iniciar sesión
                                    </button>
                                </div>
                                <p className="bottom-0 text-white text-xs p-2 cursor-pointer">
                                    ¿Olvidaste tu contraseña?, clic aquí.
                                </p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}