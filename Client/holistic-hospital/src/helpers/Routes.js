export function convertRoutes(navigator) {
    return [
        { 
            label: 'Usuarios',
            command: (event) => {
                navigator('/landing/usuarios');
            }, 
        },
        { 
            label: 'Expediente',
            items: [
                {
                    label: 'Inmunizaciones',
                    command: (event) => {
                        navigator('/landing/expediente/inmunizaciones');
                    }
                },
                {
                    label: 'Exámenes realizados',
                    command: (event) =>  {
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
                    label: 'Asignar turnos',
                    command: (event) => {
                        navigator('/landing/citas/asignar-turnos');
                    },
                },
            ]
        }
    
    ]
}