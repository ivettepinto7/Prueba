import React from 'react';

//Helpers imports
import logo from '../logo.png';

export default function LeftLoginSection() {
    return (
        <div
            className="relative sm:w-1/2 xl:w-3/5 bg-blue-800 h-full hidden md:flex flex-auto items-center justify-center p-10 overflow-hidden  text-white bg-no-repeat bg-cover relative" style={{ backgroundPosition: 'center', backgroundSize: '40vmin', backgroundImage: `url(${logo})` }}>
            <div className="absolute bg-black  opacity-25 inset-0 z-0"></div>
        </div>
    )
}
