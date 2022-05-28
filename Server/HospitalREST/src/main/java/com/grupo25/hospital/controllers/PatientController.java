package com.grupo25.hospital.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo25.hospital.models.dtos.InmunizationsDTO;
import com.grupo25.hospital.models.dtos.MessageDTO;
import com.grupo25.hospital.models.dtos.PrevAppointmentDTO;
import com.grupo25.hospital.models.dtos.RemindersDTO;
import com.grupo25.hospital.models.dtos.TestListDTO;
import com.grupo25.hospital.models.dtos.UserPrescriptionDTO;

@RestController
@RequestMapping("")
public class PatientController {

	@GetMapping("/expediente/inmunizaciones")
	public ResponseEntity<List<InmunizationsDTO>> getInmunizations(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener inmunizaciones
			List<InmunizationsDTO> inmunizationList= new ArrayList<>();
			return new ResponseEntity<List<InmunizationsDTO>>(
					inmunizationList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/expediente/examenes-realizados")
	public ResponseEntity<List<TestListDTO>> getDoneTests(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener examenes
			List<TestListDTO> doneTestList= new ArrayList<>();
			return new ResponseEntity<List<TestListDTO>>(
					doneTestList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/expediente/recetas-medicas")
	public ResponseEntity<List<UserPrescriptionDTO>> getPrescriptions(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener recetas
			List<UserPrescriptionDTO> prescriptionList= new ArrayList<>();
			return new ResponseEntity<List<UserPrescriptionDTO>>(
					prescriptionList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/expediente/citas-previas")
	public ResponseEntity<List<PrevAppointmentDTO>> getPreviousAppointments(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener citas
			List<PrevAppointmentDTO> previousAppointmentsList= new ArrayList<>();
			return new ResponseEntity<List<PrevAppointmentDTO>>(
					previousAppointmentsList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/citas")
	public ResponseEntity<MessageDTO> bookAppointment(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de reservar citas
			
			return new ResponseEntity<MessageDTO>(
					new MessageDTO("Reservada correctamente"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/recordatorios")
	public ResponseEntity<List<RemindersDTO>> getRecordatorios(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener recetas
			List<RemindersDTO> recordatoriosList= new ArrayList<>();
			return new ResponseEntity<List<RemindersDTO>>(
					recordatoriosList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
