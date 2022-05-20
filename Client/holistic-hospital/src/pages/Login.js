import React, { useState, useEffect, useRef, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { UserContext, SetUserContext } from '../contexts/UserContext/UserContext';

//Components imports
import { InputNumber } from 'primereact/inputnumber';
import { Password } from 'primereact/password';
import { Toast } from 'primereact/toast';

//Helpers imports
import logo from '../logo.png';
import { People } from '../helpers/UsersList'
import LeftLoginSection from '../components/LeftLoginSection';

export default function Login() {
    const { token } = useContext(UserContext);
    const setUser = useContext(SetUserContext);
    const navigate = useNavigate();
    const toast = useRef(null);

    const people = People;
    const [userCode, setUserCode] = useState(null);//For input in login form
    const [password, setPassword] = useState("");//For input in login form
    const isLogged = token !== '';

    useEffect(() => {
        if (isLogged) navigate("/landing");
    }, [isLogged, navigate]);

    const login = () => {
        try {
            const foundPerson = people.find((person) => {
                return person.code === userCode && person.password === password;
            })
            if (foundPerson !== undefined && foundPerson.status === true) {
                setUser({
                    token: foundPerson.token,
                    code: foundPerson.code,
                    name: foundPerson.name,
                    last_name: foundPerson.last_name,
                    email: foundPerson.email,
                    rol: foundPerson.rol,
                    status: foundPerson.status,
                    isLogged: true,
                })
                navigate('/landing');
            }
            else
                toast.current.show({
                    severity: 'error',
                    summary: 'Error al iniciar sesión, es probable que su cuenta esté inactiva o verifique los campos',
                    detail: 'Datos incorrectos',
                    life: 6000,
                    style: { marginLeft: '20%' }
                });

        } catch (error) {
            console.log(error);
        }
    }
    return (
        <div>
            <div className="relative min-h-screen  grid bg-black ">
                <Toast ref={toast} />
                <div className="flex flex-col sm:flex-row items-center md:items-start sm:justify-center md:justify-start flex-auto min-w-0 ">
                    <LeftLoginSection />
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

                            <form onSubmit={(e) => { e.preventDefault() }} className="flex flex-col block justify-center items-center p-5 w-full h-3/4 rounded-md shadow-md">
                                <span className="p-float-label">
                                    <InputNumber
                                        id="usercode"
                                        mode="decimal"
                                        value={userCode}
                                        onChange={(e) => setUserCode(e.value)}
                                    />
                                    <label htmlFor="usercode">Código de usuario</label>
                                </span>
                                <br />
                                <span className="p-float-label">
                                <Password
                                    id="password"
                                    autoComplete='current'
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                    feedback={false}
                                    toggleMask
                                    className="my-2"
                                />
                                <label htmlFor="password">Contraseña</label>
                            </span>
                            <div className="flex flex-row justify-center w-full">
                                <button
                                    onClick={(e) => {
                                        e.preventDefault();
                                        login()
                                    }}
                                    className="lg:w-1/2 w-full flex justify-center text-white p-2 rounded-full tracking-wide font-bold focus:outline-none focus:shadow-outline hover:bg-indigo-600 shadow-lg bg-blue-800 cursor-pointer transition ease-in duration-300"
                                >
                                    Iniciar sesión
                                </button>
                            </div>
                            <p className="bottom-0 text-white text-xs p-2 cursor-pointer" onClick={() => navigate("/recuperar")}>
                                ¿Olvidaste tu contraseña?, clic aquí.
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        </div >
    );
}