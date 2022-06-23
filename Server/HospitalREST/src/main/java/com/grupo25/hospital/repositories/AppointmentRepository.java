package com.grupo25.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo25.hospital.models.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
