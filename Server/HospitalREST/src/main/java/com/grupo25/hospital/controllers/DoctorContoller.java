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

import com.grupo25.hospital.models.dtos.CitasDiaDTO;
import com.grupo25.hospital.models.dtos.CloseAppointmentDTO;
import com.grupo25.hospital.models.dtos.CreatePrescriptionDTO;
import com.grupo25.hospital.models.dtos.ExpedienteDTO;
import com.grupo25.hospital.models.dtos.ExpedientePacienteDTO;
import com.grupo25.hospital.models.dtos.GetEntityDTO;
import com.grupo25.hospital.models.dtos.MessageDTO;

@RestController
@RequestMapping("")
public class DoctorContoller {
	
	@GetMapping("/citas-dia")
	public ResponseEntity<List<CitasDiaDTO>> getDayAppointments(GetEntityDTO doctor ,BindingResult result){
		try {
			//TODO implementar logica de obtener usuarios
			List<CitasDiaDTO> listaCitas= new ArrayList<>();
			return new ResponseEntity<List<CitasDiaDTO>>(
					listaCitas,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/citas-dia/consulta/expediente")
	public ResponseEntity<List<ExpedienteDTO>> getUserExpediente(ExpedientePacienteDTO expediente,BindingResult result){
		try {
			//TODO implementar logica de obtener usuarios
			List<ExpedienteDTO> listaExpedientes= new ArrayList<>();
			return new ResponseEntity<List<ExpedienteDTO>>(
					listaExpedientes,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/citas-dia/consulta/receta/crear")
	public ResponseEntity<MessageDTO> createPrescription(CreatePrescriptionDTO receta,BindingResult result){
		try {
			//TODO implementar logica de crear 
			return new ResponseEntity<>(
					new MessageDTO("Receta creada"),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/citas-dia/consulta/finalizar")
	public ResponseEntity<MessageDTO> finishAppointment(CloseAppointmentDTO finalizar,BindingResult result){
		try {
			//TODO implementar logica de crear 
			return new ResponseEntity<>(
					new MessageDTO("Consulta finalizada"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
