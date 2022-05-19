import { UserRoles } from "./Roles";

export function convertRoutes(navigator) {
    return [
        {
            label: 'Usuarios',
            command: (event) => {
                navigator('/landing/usuarios');
            },
            path: '/landing/usuarios',
            roles: [UserRoles.ADMINISTRADOR, UserRoles.SECRETARIA],
        },
        {
            label: 'Expediente',
            path: '/landing/expediente',
            roles: [UserRoles.USUARIO],
            items: [
                {
                    label: 'Inmunizaciones',
                    rolesi: [UserRoles.USUARIO],
                    command: (event) => {
                        navigator('/landing/expediente/inmunizaciones');
                    },
                    pathi: '/landing/expediente/inmunizaciones',
                },
                {
                    label: 'Exámenes realizados',
                    rolesi: [UserRoles.USUARIO],
                    command: (event) => {
                        navigator('/landing/expediente/examenes-realizados');
                    },
                    pathi: '/landing/expediente/examenes-realizados',
                },
                {
                    label: 'Recetas médicas',
                    rolesi: [UserRoles.USUARIO],
                    command: (event) => {
                        navigator('/landing/expediente/recetas-medicas');
                    },
                    pathi: '/landing/expediente/recetas-medicas',
                },
                {
                    label: 'Citas previas',
                    rolesi: [UserRoles.USUARIO],
                    command: (event) => {
                        navigator('/landing/expediente/citas-previas');
                    },
                    pathi: '/landing/expediente/citas-previas',
                },
            ]
        },
        {
            label: 'Citas',
            roles: [UserRoles.USUARIO],
            path: '/landing/citas',
            items: [
                {
                    label: 'Agendar cita médica',
                    rolesi: [UserRoles.USUARIO],
                    command: (event) => {
                        navigator('/landing/citas/cita-medica');
                    },
                    pathi: '/landing/citas/cita-medica',
                },
                {
                    label: 'Agendar examen',
                    rolesi: [UserRoles.USUARIO],
                    command: (event) => {
                        navigator('/landing/citas/cita-examenes');
                    },
                    pathi: '/landing/citas/cita-examenes',
                },
                {
                    label: 'Agendar inmunización',
                    rolesi: [UserRoles.USUARIO],
                    command: (event) => {
                        navigator('/landing/citas/cita-inmunizacion');
                    },
                    pathi: '/landing/citas/cita-inmunizacion',
                },
            ]
        },
        {
            label: 'Recordatorios',
            roles: [UserRoles.USUARIO],
            command: (event) => {
                navigator('/landing/recordatorios');
            },
            path: '/landing/recordatorios',
        },
        {
            label: 'Agregar examen',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/agregar-examen');
            },
            path: '/landing/agregar-examen',
        },
        {
            label: 'Agregar vacuna',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/agregar-vacuna');
            },
            path: '/landing/agregar-vacuna',
        },
        {
            label: 'Agregar área de hospital',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/agregar-area');
            },
            path: '/landing/agregar-area',
        },
        {
            label: 'Agregar medicamento',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/agregar-medicamento');
            },
            path: '/landing/agregar-medicamento',
        },
        {
            label: 'Asignar turnos',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/asignar-turnos');
            },
            path: '/landing/asignar-turnos',
        },
    ]
}