package com.grupo25.hospital.services;

import com.grupo25.hospital.models.dtos.ScheduleAppointmentDTO;
import com.grupo25.hospital.models.entities.Person;

public interface AppointmentService {
	void register(ScheduleAppointmentDTO newSchedule, Person person) throws Exception;
}
