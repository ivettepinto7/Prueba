import React, { useState, useEffect, useRef, useContext } from 'react';
import MenuContext from '../../contexts/MenuContext/MenuContext';
import { useForm, Controller } from 'react-hook-form';

//Components imports
import { Dialog } from 'primereact/dialog';
import { Toast } from 'primereact/toast';
import { Button } from 'primereact/button';
import { Divider } from 'primereact/divider';
import { InputText } from 'primereact/inputtext';
import { classNames } from 'primereact/utils';
import { Password } from 'primereact/password';
import { SelectButton } from 'primereact/selectbutton';

import "../cssFiles/FormDemo.css";

export default function EditUser() {
    const { emergentEditUserState } = useContext(MenuContext);
    const menuContext = useContext(MenuContext);

    const toast = useRef(null);

    const [display, setDisplay] = useState(false);

    const [showMessage, setShowMessage] = useState(false);
    const [formData, setFormData] = useState({});

    useEffect(() => {
        setDisplay(emergentEditUserState);
    }, [emergentEditUserState]);

    const defaultValues = {
        email: '',
        password: '',
        status: null,
    }

    const statusOptions = ['Activo', 'Inactivo'];

    const { control, formState: { errors }, handleSubmit, reset } = useForm({ defaultValues });

    const onSubmit = (data) => {
        setFormData(data);
        setShowMessage(true);
        console.log(formData);

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

    /**
* Upload New User Emergent logic section code
*/
    const dialogFuncMap = {
        display: setDisplay,
    };

    const onHide = (name) => {
        menuContext.settingEmergentEditUserState();
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
                header="Editar usuario"
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
                                <b>{menuContext.userCode}</b> actualizado con éxito.
                            </p>
                        </div>
                    </Dialog>

                    <div className="m-1 w-full flex justify-content-center">
                        <div className="card w-full">
                            <form autoComplete='off' onSubmit={handleSubmit(onSubmit)} className="grid grid-cols-2 p-fluid w-full">

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
                                        <label htmlFor="password" className={classNames({ 'p-error': errors.password })}>Nueva contraseña*</label>
                                    </span>
                                    {getFormErrorMessage('password')}
                                </div>

                                <div className="field">
                                    <span className='p-inline-label'>
                                        <label htmlFor="status" className={classNames({ 'p-error': !!errors.status })}>Estado*</label>
                                        <Controller name="status" control={control}
                                            rules={{ required: 'El estado es requerido.' }}
                                            render={({ field, fieldState }) => (
                                                <SelectButton id={field.name} {...field} className={classNames({ 'p-invalid': fieldState.invalid })} options={statusOptions} unselectable={false} />
                                            )} />
                                    </span>
                                    {getFormErrorMessage('status')}
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </Dialog>
        </div>
    )
}
