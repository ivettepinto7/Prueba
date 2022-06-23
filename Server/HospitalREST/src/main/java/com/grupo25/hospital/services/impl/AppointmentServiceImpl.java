package com.grupo25.hospital.services.impl;

import org.springframework.stereotype.Service;

import com.grupo25.hospital.models.dtos.ScheduleAppointmentDTO;
import com.grupo25.hospital.models.entities.Appointment;
import com.grupo25.hospital.models.entities.Person;
import com.grupo25.hospital.services.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Override
	public void register(ScheduleAppointmentDTO newSchedule, Person person) throws Exception {
		
		//consulta
		if(newSchedule.getType()==2) {
			Appointment newAppointment = new Appointment();
			newAppointment.setId_patient(person);
			newAppointment.setAppointment_time(newSchedule.getDate());
			newAppointment.setStatus(false);
			newAppointment.setId_appointment_type(newSchedule.getType());
			
			
		}
		
		
		
	}

}
