import React, { useEffect, useContext } from "react";
import { Outlet } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import { UserContext } from "../contexts/UserContext/UserContext";

//Components imports
import SideBar from "../components/SideBar";

export default function Landing() {
    const navigate = useNavigate();
    const { token } = useContext(UserContext);
    const isLogged = token !== '';

    useEffect(() => {
        if(!isLogged) navigate("/");
    },[isLogged, navigate]);

    return (
        <div className="w-full h-screen">
            <SideBar />
            <Outlet />
        </div>
    );
}