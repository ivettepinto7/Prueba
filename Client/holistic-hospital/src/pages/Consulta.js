import React, { useState, useEffect, useContext, useRef } from 'react'
import MenuContext from '../contexts/MenuContext/MenuContext';
import { useForm, Controller } from 'react-hook-form';

//Components imports
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import { Toast } from 'primereact/toast';
import { InputText } from 'primereact/inputtext';
import { Dropdown } from 'primereact/dropdown';
import { classNames } from 'primereact/utils';
import { InputNumber } from 'primereact/inputnumber';

import "../components/cssFiles/FormDemo.css";
import { PatientInConsult } from "../helpers/PatientInConsult";

export default function Consulta() {

/*
    const renderFooter = (name) => {
        return (
            <div>
                <Button
                    label="Cancelar"
                    icon="pi pi-times"
                    onClick={() => onHide(name)}
                    className="p-button-text"
                />
                <Button
                    label="Crear"
                    type='submit'
                    onClick={handleSubmit(onSubmit)}
                    icon="pi pi-check" />
            </div>
        );
    };
    */


     /*
            <Toast ref={toast} />
            <Dialog
                breakpoints={{'960px': '75vw', '640px': '100vw'}}
                header="Crear examen"
                visible={display}
                style={{ width: '50vw' }}
                //footer={renderFooter('display')}
                //onHide={() => onHide('display')}
            >

                <div className="form-demo w-full">
                    <Dialog visible={showMessage} onHide={() => setShowMessage(false)} position="top"  footer={dialogFooter}  showHeader={false} breakpoints={{ '960px': '80vw' }} style={{ width: '30vw' }}>
                        <div className="flex justify-content-center flex-column pt-6 px-3">
                            <i className="pi pi-check-circle" style={{ fontSize: '5rem', color: 'var(--green-500)' }}></i>
                            <p style={{ lineHeight: 1.5, textIndent: '1rem' }}>
                                <b>{formData.name}</b> registrado con éxito.
                            </p>
                        </div>
                    </Dialog>

                    <div className="m-1 w-full flex justify-content-center">

                        <div className="card w-full">
                            
                            <form autoComplete='off' onSubmit={handleSubmit(onSubmit)} className="grid grid-cols-2 p-fluid w-full">


                                <div className="field">
                                    <span className="p-float-label">
                                        <Controller name="name" control={control} rules={{ required: 'El nombre es requerido' }} render={({ field, fieldState }) => (
                                            <InputText id={field.name} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                                        )} />
                                        <label htmlFor="name" className={classNames({ 'p-error': errors.name })}>Nombre*</label>
                                    </span>
                                    {getFormErrorMessage('name')}
                                </div>


                                <div className="field">
                                    <span className="p-float-label">
                                        <Controller name="gender" control={control} rules={{ required: 'El género es requerido.' }} render={({ field }) => (
                                            <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} optionLabel='name' />
                                        )} />
                                        <label htmlFor="gender" className={classNames({ 'p-error': errors.gender })}>Género</label>
                                    </span>
                                    {getFormErrorMessage('gender')}
                                </div>

                                <div className="field">
                                    <span className="p-float-label">
                                        <Controller name="start_age" control={control}  render={({ field, fieldState }) => (
                                            <InputNumber id={field.name} {...field} mode="decimal" onChange={(e) => field.onChange(e.value)}  />
                                        )} />
                                        <label htmlFor="start_age" >Edad inicial</label>
                                    </span>
                                </div>

                                <div className="field">
                                    <span className="p-float-label">
                                        <Controller name="frequency" control={control}  render={({ field, fieldState }) => (
                                            <InputNumber id={field.name} {...field} mode="decimal" onChange={(e) => field.onChange(e.value)} />
                                        )} />
                                        <label htmlFor="frequency" >Frecuencia del test (en dias)</label>
                                    </span>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

            </Dialog>
            */
    return (
        <div className="flex flex-col">
           <h1>Consulta</h1>
           
        </div>
    )
}
