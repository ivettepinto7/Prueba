import React, { useState } from 'react'

//Components imports
import { RadioButton } from 'primereact/radiobutton';

//Helpers imports

//Components imports
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCalendarPlus } from '@fortawesome/free-solid-svg-icons';

export default function ScheduleAppointment() {
    const appointmentsTypes = [{name: 'Inmunización', code: 1}, {name: 'Consulta médica', code: 2}, {name: 'Examen', code: 3}];
    const [selectedAppointmentType, setSelectedAppointmentType] = useState(appointmentsTypes[1]);
    return (
        <div className='card flex justify-center'>
            <div className='w-full'>
            <div className='flex items-center justify-center my-4'>
                <FontAwesomeIcon style={{ color: '#1D4078', fontSize: '2rem' }} icon={faCalendarPlus} />
                <h1 className='lg:text-3xl mx-3 my-3 text-center'>Agendar una cita para:</h1>
            </div>
            <div className='w-full flex justify-center'>
            {
                appointmentsTypes.map((appointment) => {
                    return (
                        <div className='lg:w-1/4 flex items-center justify-center' style={{ backgroundColor: '#1D4078' }}>
                            <div key={appointment.code} className="field-radiobutton h-20 text-white lg:text-xl flex mx-4 space-between items-center justify-center">
                            <RadioButton inputId={appointment.code} name="appointment" value={appointment} onChange={(e) => setSelectedAppointmentType(e.value)} checked={selectedAppointmentType.code === appointment.code} />
                            <label className='text-center' htmlFor={appointment.code}>{appointment.name}</label>
                        </div>
                        </div>
                    )
                })
            }
            </div>
            </div>
        </div>
    )
}
