import React, { useContext, useState } from 'react'
import { UserContext } from '../contexts/UserContext/UserContext';
import { useForm } from 'react-hook-form';

//Components imports
import { RadioButton } from 'primereact/radiobutton';

//Helpers imports

//Components imports
import { Button } from 'primereact/button';
import { Dropdown } from 'primereact/dropdown';
import { Dialog } from 'primereact/dialog';
import { Calendar } from 'primereact/calendar';
import { Controller } from 'react-hook-form';
import { classNames } from 'primereact/utils';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCalendarPlus } from '@fortawesome/free-solid-svg-icons';
import { InputNumber } from 'primereact/inputnumber';

//Helpers imports
import { AreasList } from '../helpers/AreasList';
import { Inmunizations } from '../helpers/InmunizationsList';
import { Tests } from '../helpers/TestList';
import { AreaShifts } from '../helpers/AreaShifts';
import { People } from '../helpers/UsersList';

export default function ScheduleAppointment() {
    const { rol, name, last_name } = useContext(UserContext);
    const users = People;
    const appointmentsTypes = [{ name: 'Inmunización', code: 1 }, { name: 'Consulta médica', code: 2 }, { name: 'Examen', code: 3 }];
    const areasList = AreasList;
    const tests = Tests;
    const areaShifts = AreaShifts;
    const inmunizations = Inmunizations;
    const [selectedAppointmentType, setSelectedAppointmentType] = useState(appointmentsTypes[1]);

    const today = new Date();
    const tomorrow = new Date();
    tomorrow.setDate(today.getDate() + 1);
    const [showMessage, setShowMessage] = useState(false);
    const [formData, setFormData] = useState({});

    const defaultValues = {
        patient: null,
        inmunization: null,
        test: null,
        area: null,
        appointdate: null,
        appointime: null,
    }

    const { control, formState: { errors }, handleSubmit, reset, watch } = useForm({ defaultValues });
    const inmunization = watch('inmunization', false);
    const test = watch('test', false);
    const area = watch('area', false);
    const appointdate = watch('appointdate', false);
    let filteredShifts = null;

    var foundPatient = users.filter(({ code, rol }) => {
        return formData.patient === code && rol === 2;
    });

    if (selectedAppointmentType.code === 1) {
        filteredShifts = inmunization && areaShifts.filter(({ vaccine }) => {
            return (inmunization.id_inmunization === vaccine);
        });
    } else if (selectedAppointmentType.code === 2) {
        filteredShifts = area && areaShifts.filter(({ hosparea }) => {
            return (area.code === hosparea);
        });
    } else {
        filteredShifts = test && areaShifts.filter(({ id_test }) => {
            return (test.code === id_test);
        });
    }


    const onSubmit = (data) => {
        setFormData(data);
        setShowMessage(true);

        reset();
    };

    const getFormErrorMessage = (name) => {
        return errors[name] && <small className="p-error">{errors[name].message}</small>
    };

    const dialogFooter = <div className="flex justify-content-center"><Button label="OK" className="p-button-text" autoFocus onClick={() => setShowMessage(false)} /></div>;

    return (
        <div className='card flex h-full bg-gray-100'>
            {
                (rol === 2 || foundPatient.length > 0) ?
                    <Dialog visible={showMessage} onHide={() => setShowMessage(false)} position="top" footer={dialogFooter} showHeader={false} breakpoints={{ '960px': '80vw' }} style={{ width: '50vw' }}>
                        <div className="flex justify-content-center flex-column pt-6 px-3">
                            <i className="pi pi-check-circle" style={{ fontSize: '5rem', color: 'var(--green-500)' }}></i>
                            <h1 style={{ lineHeight: 1.5, textIndent: '1rem' }}>
                                Cita agendada con éxito.
                                <p>
                                    <b>Tipo: </b>{selectedAppointmentType.name}
                                </p>
                                <p>
                                    <b>Paciente: </b>{
                                        rol === 2 ? name + ' ' + last_name
                                            : rol === 3 ?
                                                foundPatient && formData.patient ? foundPatient.at(0).name + ' ' + foundPatient.at(0).last_name
                                                    :
                                                    'Usuario no encontrado'
                                                : ''
                                    }
                                </p>
                                {
                                    selectedAppointmentType && selectedAppointmentType.code === 1 ?
                                        <p>
                                            <b>Vacuna: </b>{formData.inmunization && formData.inmunization.vaccine_name}
                                        </p>
                                        :
                                        selectedAppointmentType.code === 2 ?
                                            <p>
                                                <b>Área: </b>{formData.area && formData.area.name}
                                            </p>
                                            : selectedAppointmentType.code === 3 ?
                                                <p>
                                                    <b>Examen: </b>{formData.test && formData.test.name}
                                                </p>
                                                :
                                                ""
                                }
                                <p>
                                    <b>Dia: </b>{formData.appointdate && formData.appointdate.toLocaleDateString()}
                                </p>
                                <p>
                                    <b>Turno: </b>{formData.appointime}
                                </p>
                            </h1>
                        </div>
                    </Dialog>
                    :
                    <Dialog visible={showMessage} onHide={() => setShowMessage(false)} position="top" footer={dialogFooter} showHeader={false} breakpoints={{ '960px': '80vw' }} style={{ width: '50vw' }}>
                        <div className="flex justify-content-center flex-column pt-6 px-3">
                            <i className="pi pi-exclamation-circle" style={{ fontSize: '5rem', color: 'red' }}></i>
                            <h1 style={{ lineHeight: 1.5, textIndent: '1rem' }}>
                                El usuario no fue encontrado o no es un paciente.
                            </h1>
                        </div>
                    </Dialog>
            }



            <div className='flex justify-center w-full items-center'>
                <div className='lg:w-3/4 border-4 rounded-lg py-4' style={{ backgroundColor: 'white' }}>
                    <div className='flex items-center justify-center'>
                        <FontAwesomeIcon style={{ color: '#1D4078', fontSize: '2rem' }} icon={faCalendarPlus} />
                        <h1 className='lg:text-3xl mx-3 my-3 text-center'>Agendar una cita para:</h1>
                    </div>
                    <div className='lg:flex justify-center'>
                        <div className='lg:flex lg:w-1/2 justify-center rounded-lg' style={{ backgroundColor: '#1D4078' }}>
                            {
                                appointmentsTypes.map((appointment) => {
                                    return (
                                        <div key={appointment.code}>
                                            <div key={appointment.code} className="field-radiobutton h-20 text-white lg:text-xl flex mx-4 space-between items-center justify-center">
                                                <RadioButton inputId={appointment.code} name="appointment" value={appointment} onChange={(e) => setSelectedAppointmentType(e.value)} checked={selectedAppointmentType.code === appointment.code} />
                                                <label key={appointment.code} className='text-center cursor-pointer' htmlFor={appointment.code}>{appointment.name}</label>
                                            </div>
                                        </div>
                                    )
                                })
                            }
                        </div>
                    </div>

                    <div className='flex justify-center items-center'>
                        <form onSubmit={handleSubmit(onSubmit)} className="w-1/2 pt-10 grid grid-cols-2 flex flex-col block justify-center items-center rounded-md shadow-md">
                            {
                                rol === 3 ?
                                    <div className="field mt-6">
                                        <span className="p-float-label">
                                            <Controller name="patient" control={control} rules={{ required: 'El código de paciente es requerida.' }} render={({ field }) => (
                                                <InputNumber autoFocus id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} />
                                            )} />
                                            <label htmlFor="patient" className={classNames({ 'p-error': errors.patientcode })}>Código de paciente*</label>
                                        </span>
                                        {getFormErrorMessage('patient')}
                                    </div>
                                    :
                                    ""
                            }
                            {
                                selectedAppointmentType && selectedAppointmentType.code === 1 ?
                                    <div className="field mt-6">
                                        <span className="p-float-label">
                                            <Controller name="inmunization" control={control} rules={{ required: 'La vacuna es requerida.' }} render={({ field }) => (
                                                <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={inmunizations} optionLabel='vaccine_name' />
                                            )} />
                                            <label htmlFor="inmunization" className={classNames({ 'p-error': errors.inmunization })}>Vacuna*</label>
                                        </span>
                                        {getFormErrorMessage('inmunization')}
                                    </div>
                                    :
                                    ""
                            }

                            {
                                selectedAppointmentType && selectedAppointmentType.code === 3 ?
                                    <div className="field mt-6">
                                        <span className="p-float-label">
                                            <Controller name="test" control={control} rules={{ required: 'El examen es requerido.' }} render={({ field }) => (
                                                <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={tests} optionLabel='name' />
                                            )} />
                                            <label htmlFor="test" className={classNames({ 'p-error': errors.test })}>Examen*</label>
                                        </span>
                                        {getFormErrorMessage('test')}
                                    </div>
                                    :
                                    ""
                            }

                            {
                                selectedAppointmentType && selectedAppointmentType.code === 2 ?
                                    <div className="field mt-8">
                                        <span className="p-float-label">
                                            <Controller name="area" control={control} rules={{ required: 'El área es requerido.' }} render={({ field }) => (
                                                <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={areasList} optionLabel='name' />
                                            )} />
                                            <label htmlFor="area" className={classNames({ 'p-error': errors.area })}>Área*</label>
                                        </span>
                                        {getFormErrorMessage('area')}
                                    </div>
                                    :
                                    ""
                            }

                            {
                                selectedAppointmentType && selectedAppointmentType.code === 1 && inmunization &&
                                <div className="field mt-8">
                                    <span className="p-float-label">
                                        <Controller name="appointdate" control={control} rules={{ required: 'La fecha de cita es requerida.' }} render={({ field }) => (
                                            <Calendar minDate={tomorrow} id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} dateFormat="yy/mm/dd" showIcon mask="99/99/9999" />
                                        )} />
                                        <label htmlFor="appointdate" className={classNames({ 'p-error': errors.appointdate })}>Fecha de cita*</label>
                                    </span>
                                    {getFormErrorMessage('appointdate')}
                                </div>
                            }

                            {
                                selectedAppointmentType && selectedAppointmentType.code === 2 && area &&
                                <div className="field mt-8">
                                    <span className="p-float-label">
                                        <Controller name="appointdate" control={control} rules={{ required: 'La fecha de cita es requerida.' }} render={({ field }) => (
                                            <Calendar minDate={tomorrow} id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} dateFormat="yy/mm/dd" showIcon mask="99/99/9999" />
                                        )} />
                                        <label htmlFor="appointdate" className={classNames({ 'p-error': errors.appointdate })}>Fecha de cita*</label>
                                    </span>
                                    {getFormErrorMessage('appointdate')}
                                </div>
                            }

                            {
                                selectedAppointmentType && selectedAppointmentType.code === 3 && test &&
                                <div className="field mt-8">
                                    <span className="p-float-label">
                                        <Controller name="appointdate" control={control} rules={{ required: 'La fecha de cita es requerida.' }} render={({ field }) => (
                                            <Calendar minDate={tomorrow} id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} dateFormat="yy/mm/dd" showIcon mask="99/99/9999" />
                                        )} />
                                        <label htmlFor="appointdate" className={classNames({ 'p-error': errors.appointdate })}>Fecha de cita*</label>
                                    </span>
                                    {getFormErrorMessage('appointdate')}
                                </div>
                            }

                            {
                                appointdate &&
                                <div className="field mt-8">
                                    <span className="p-float-label">
                                        <Controller name="appointime" control={control} rules={{ required: 'El turno de cita es requerido.' }} render={({ field }) => (
                                            <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={filteredShifts.at(0).shifts} />
                                        )} />
                                        <label htmlFor="appointime" className={classNames({ 'p-error': errors.appointime })}>Turno*</label>
                                    </span>
                                    {getFormErrorMessage('appointime')}
                                </div>
                            }

                            <br />

                            <div className='col-span-2 flex justify-center mt-5'>
                                <button
                                    type="submit"
                                    className="w-1/2 flex justify-center text-white p-2 rounded-full tracking-wide font-bold focus:outline-none focus:shadow-outline hover:bg-indigo-600 shadow-lg bg-blue-800 cursor-pointer transition ease-in duration-300"

                                >
                                    Agendar
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div >
        </div >
    )
}
