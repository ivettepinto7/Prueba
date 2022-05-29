import React, { useState, useEffect, useContext, useRef } from 'react'
import MenuContext from '../../contexts/MenuContext/MenuContext';
import { useForm, Controller } from 'react-hook-form';

//Components imports
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import { Toast } from 'primereact/toast';
import { InputText } from 'primereact/inputtext';
import { Dropdown } from 'primereact/dropdown';
import { Calendar } from 'primereact/calendar';
import { Password } from 'primereact/password';
import { Divider } from 'primereact/divider';
import { classNames } from 'primereact/utils';

import "../cssFiles/FormDemo.css";
import { GendersList } from '../../helpers/GendersList';
import { Roles } from '../../helpers/Roles';
import { AreasList } from '../../helpers/AreasList';

export default function CreateNewUser() {
    const { emergentNewUserState } = useContext(MenuContext);
    const menuContext = useContext(MenuContext);

    const gendersList =  GendersList;
    const roles = Roles;
    const areasList = AreasList;
    const toast = useRef(null);
    
    var today = new Date();
    const [display, setDisplay] = useState(false);
    const [showMessage, setShowMessage] = useState(false);
    const [formData, setFormData] = useState({});

    const defaultValues = {
        name: '',
        lastname: '',
        gender: null,
        email: '',
        password: '',
        role: null,
        birthdate: null,
        area: null,
    }

    const { control, formState: { errors }, handleSubmit, reset, watch } = useForm({ defaultValues });
    const selectedRole = watch('role',false);

    const onSubmit = (data) => {
        setFormData(data);
        setShowMessage(true);

        reset();
    };

    const getFormErrorMessage = (name) => {
        return errors[name] && <small className="p-error">{errors[name].message}</small>
    };

    const dialogFooter = <div className="flex justify-content-center"><Button label="OK" className="p-button-text" autoFocus onClick={() => setShowMessage(false)} /></div>;
    const passwordHeader = <h6>Escribe una contraseña</h6>;
    const passwordFooter = (
        <>
            <Divider />
            <p className="mt-2">Sugerencias</p>
            <ul className="pl-2 ml-2 mt-0" style={{ lineHeight: '1.5' }}>
                <li>Al menos una minuscula</li>
                <li>Al menos una mayúscula</li>
                <li>Al menos un número</li>
                <li>Minimo 4 caracteres</li>
            </ul>
        </>
    );

    useEffect(() => {
        setDisplay(emergentNewUserState);
    }, [emergentNewUserState]);

    /**
* Upload New User Emergent logic section code
*/
    const dialogFuncMap = {
        display: setDisplay,
    };

    const onHide = (name) => {
        menuContext.settingEmergentNewUserState();
        dialogFuncMap[`${name}`](false);
    };

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

    return (
        <div className="flex flex-col">
            <Toast ref={toast} />
            <Dialog
                breakpoints={{ '960px': '75vw', '640px': '100vw' }}
                header="Crear usuario"
                visible={display}
                style={{ width: '50vw' }}
                footer={renderFooter('display')}
                onHide={() => onHide('display')}
            >

                <div className="form-demo w-full">
                    <Dialog visible={showMessage} onHide={() => setShowMessage(false)} position="top" footer={dialogFooter} showHeader={false} breakpoints={{ '960px': '80vw' }} style={{ width: '30vw' }}>
                        <div className="flex justify-content-center flex-column pt-6 px-3">
                            <i className="pi pi-check-circle" style={{ fontSize: '5rem', color: 'var(--green-500)' }}></i>
                            <p style={{ lineHeight: 1.5, textIndent: '1rem' }}>
                                <b>{formData.name}</b> registrado con éxito.
                            </p>
                        </div>
                    </Dialog>

                    <div className="m-1 w-full flex justify-content-center">
                        <div className="card w-full">
                            <form onSubmit={handleSubmit(onSubmit)} className="grid grid-cols-2 p-fluid w-full">
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
                                        <Controller name="lastname" control={control} rules={{ required: 'El apellido es requerido' }} render={({ field, fieldState }) => (
                                            <InputText id={field.name} {...field} className={classNames({ 'p-invalid': fieldState.invalid })} />
                                        )} />
                                        <label htmlFor="lastname" className={classNames({ 'p-error': errors.name })}>Apellido*</label>
                                    </span>
                                    {getFormErrorMessage('lastname')}
                                </div>

                                <div className="field">
                                    <span className="p-float-label">
                                        <Controller name="gender" control={control} rules={{ required: 'El género es requerido.' }} render={({ field }) => (
                                            <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={gendersList} optionLabel='name' />
                                        )} />
                                        <label htmlFor="gender" className={classNames({ 'p-error': errors.role })}>Género*</label>
                                    </span>
                                    {getFormErrorMessage('gender')}
                                </div>

                                <div className="field">
                                    <span className="p-float-label p-input-icon-right">
                                        <i className="pi pi-envelope" />
                                        <Controller name="email" control={control}
                                            rules={{ required: 'El correo electrónico es requerido.', pattern: { value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i, message: 'Dirección de correo electrónico incorrecta. E.g. ejemplo@email.com' } }}
                                            render={({ field, fieldState }) => (
                                                <InputText id={field.name} {...field} className={classNames({ 'p-invalid': fieldState.invalid })} />
                                            )} />
                                        <label htmlFor="email" className={classNames({ 'p-error': !!errors.email })}>Correo electrónico*</label>
                                    </span>
                                    {getFormErrorMessage('email')}
                                </div>

                                <div className="field">
                                    <span className="p-float-label">
                                        <Controller name="password" control={control} rules={{ required: 'La contraseña es requerida.' }} render={({ field, fieldState }) => (
                                            <Password autoComplete='off' id={field.name} {...field} toggleMask className={classNames({ 'p-invalid': fieldState.invalid })} header={passwordHeader} footer={passwordFooter} />
                                        )} />
                                        <label htmlFor="password" className={classNames({ 'p-error': errors.password })}>Contraseña*</label>
                                    </span>
                                    {getFormErrorMessage('password')}
                                </div>

                                <div className="field">
                                    <span className="p-float-label">
                                        <Controller name="role" control={control} rules={{ required: 'El rol es requerido.' }} render={({ field }) => (
                                            <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={roles} optionLabel='name' />
                                        )} />
                                        <label htmlFor="role" className={classNames({ 'p-error': errors.role })}>Rol</label>
                                    </span>
                                    {getFormErrorMessage('role')}
                                </div>

                                {
                                        selectedRole && (selectedRole['code'] === 4 || selectedRole['code'] === 3) ?
                                        <div className="field">
                                            <span className="p-float-label">
                                                <Controller name="area" control={control} rules={{ required: 'El área es requerida.' }} render={({ field }) => (
                                                    <Dropdown id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} options={areasList} optionLabel='name' />
                                                )} />
                                                <label htmlFor="area" className={classNames({ 'p-error': errors.role })}>Área*</label>
                                            </span>
                                            {getFormErrorMessage('area')}
                                        </div> 
                                        :
                                        ""
                                    }

                                <div className="field">
                                    <span className="p-float-label">
                                        <Controller name="birthdate" control={control} rules={{ required: 'La fecha de nacimiento es requerida.' }} render={({ field }) => (
                                            <Calendar id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} dateFormat="yy/mm/dd" mask="99/99/9999" showIcon maxDate={today} />
                                        )} />
                                        <label htmlFor="birthdate" className={classNames({ 'p-error': errors.birthdate })}>Fecha de nacimiento</label>
                                    </span>
                                    {getFormErrorMessage('birthdate')}
                                </div>

                            </form>
                        </div>
                    </div>
                </div>

            </Dialog>
        </div>
    )
}
