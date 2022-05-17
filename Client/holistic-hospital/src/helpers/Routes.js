import { UserRoles } from "./Roles";

export function convertRoutes(navigator) {
    return [
        {
            label: 'Usuarios',
            command: (event) => {
                navigator('/landing/usuarios');
            },
            roles: [UserRoles.ADMINISTRADOR, UserRoles.SECRETARIA],
        },
        {
            label: 'Expediente',
            roles: [UserRoles.USUARIO],
            items: [
                {
                    label: 'Inmunizaciones',
                    command: (event) => {
                        navigator('/landing/expediente/inmunizaciones');
                    }
                },
                {
                    label: 'Exámenes realizados',
                    command: (event) => {
                        navigator('/landing/expediente/examenes-realizados');
                    },
                },
                {
                    label: 'Recetas médicas',
                    command: (event) => {
                        navigator('/landing/expediente/recetas-medicas');
                    },
                },
                {
                    label: 'Citas previas',
                    command: (event) => {
                        navigator('/landing/expediente/citas-previas');
                    },
                },
            ]
        },
        {
            label: 'Citas',
            roles: [UserRoles.USUARIO],
            items: [
                {
                    label: 'Agendar cita médica',
                    command: (event) => {
                        navigator('/landing/citas/cita-medica');
                    },
                },
                {
                    label: 'Agendar examen',
                    command: (event) => {
                        navigator('/landing/citas/cita-examenes');
                    },
                },
                {
                    label: 'Agendar inmunización',
                    command: (event) => {
                        navigator('/landing/citas/cita-inmunizacion');
                    },
                },
            ]
        },
        {
            label: 'Recordatorios',
            roles: [UserRoles.USUARIO],
            command: (event) => {
                navigator('/landing/recordatorios');
            },
        },
        {
            label: 'Agregar examen',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/agregar-examen');
            },
        },
        {
            label: 'Agregar vacuna',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/agregar-vacuna');
            },
        },
        {
            label: 'Agregar área de hospital',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/agregar-area');
            },
        },
        {
            label: 'Agregar medicamento',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/agregar-medicamento');
            },
        },
        {
            label: 'Asignar turnos',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/asignar-turnos');
            },
        },
    ]
}