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

import com.grupo25.hospital.models.dtos.MessageDTO;

@RestController
@RequestMapping("")
public class PatientController {

	@GetMapping("/expediente/inmunizaciones")
	public ResponseEntity<List<InmunizationsDTO>> getInmunizations(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener inmunizaciones
			List<String> inmunizationList= new ArrayList<>();
			return new ResponseEntity<List<String>>(
					InmunizationList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/expediente/examenes-realizados")
	public ResponseEntity<List<DoneTestsDTO>> getDoneTests(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener examenes
			List<String> doneTestList= new ArrayList<>();
			return new ResponseEntity<List<String>>(
					DoneTestList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/expediente/recetas-medicas")
	public ResponseEntity<List<PrescriptionsDTO>> getPrescriptions(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener recetas
			List<String> prescriptionList= new ArrayList<>();
			return new ResponseEntity<List<String>>(
					prescriptionList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/expediente/citas-previas")
	public ResponseEntity<List<PreviousAppointmentsDTO>> getPreviousAppointments(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener citas
			List<String> previousAppointmentsList= new ArrayList<>();
			return new ResponseEntity<List<String>>(
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
	public ResponseEntity<List<RecordatoriosDTO>> getRecordatorios(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener recetas
			List<String> recordatoriosList= new ArrayList<>();
			return new ResponseEntity<List<String>>(
					recordatoriosList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
