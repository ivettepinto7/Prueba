export const Routes = [
    { 
        label: 'Usuarios',
        url: 'landing/usuarios', 
    },
    { 
        label: 'Expediente',
        items: [
            {
                label: 'Inmunizaciones',
                url: 'expediente/inmunizaciones',
            },
            {
                label: 'Exámenes realizados',
                url: 'expediente/examenes-realizados',
            },
            {
                label: 'Recetas médicas',
                url: 'expediente/recetas-medicas',
            },
            {
                label: 'Citas previas',
                url: 'expediente/citas-previas',
            },
        ]
    },
    { 
        label: 'Citas',
        items: [
            {
                label: 'Agendar cita médica',
                url: 'citas/cita-medica',
            },
            {
                label: 'Agendar examen',
                url: 'citas/cita-examenes',
            },
            {
                label: 'Aignar turnos',
                url: 'citas/asignar-turnos',
            },
        ]
    }

]