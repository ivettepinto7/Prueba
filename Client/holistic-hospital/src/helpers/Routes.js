import { UserRoles } from "./Roles";

export function convertRoutes(navigator) {
    return [
        {
            label: 'Usuarios',
            command: (event) => {
                navigator('/landing/usuarios');
            },
            path: '/landing/usuarios',
            roles: [UserRoles.ADMINISTRADOR],
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
                        navigator('/landing/citas/cita-examen');
                    },
                    pathi: '/landing/citas/cita-examen',
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
            label: 'Citas del dia',
            roles: [UserRoles.SECRETARIA, UserRoles.MEDICO],
            command: (event) => {
                navigator('/landing/citas-dia')
            },
            path: '/landing/citas-dia',
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
            label: 'Exámenes',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/examenes');
            },
            path: '/landing/examenes',
        },
        {
            label: 'Vacunas',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/vacunas');
            },
            path: '/landing/vacunas',
        },
        {
            label: 'Áreas',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/areas');
            },
            path: '/landing/areas',
        },
        {
            label: 'Medicamentos',
            roles: [UserRoles.ADMINISTRADOR],
            command: (event) => {
                navigator('/landing/medicamentos');
            },
            path: '/landing/medicamentos',
        },
    ]
}