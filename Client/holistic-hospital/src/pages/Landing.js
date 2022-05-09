import React from "react";
import { Outlet } from "react-router-dom";

//Components imports
import SideBar from "../components/SideBar";

export default function Header() {
    return (
        <div className="w-full h-screen">
            <SideBar />
            <Outlet />
        </div>
    );
}