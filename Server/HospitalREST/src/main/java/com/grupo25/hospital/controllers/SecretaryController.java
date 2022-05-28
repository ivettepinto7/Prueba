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
import com.grupo25.hospital.models.dtos.MessageDTO;

@RestController
@RequestMapping("")
public class SecretaryController {

	@GetMapping("/citas-dia")
	public ResponseEntity<List<CitasDiaDTO>> getDayAppointments(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener usuarios
			List<CitasDiaDTO> listaUsers= new ArrayList<>();
			return new ResponseEntity<List<CitasDiaDTO>>(
					listaUsers,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/citas-dia/consulta/expediente")
	public ResponseEntity<List<ExpedienteDTO>> getUserExpediente(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener usuarios
			List<String> listaUsers= new ArrayList<>();
			return new ResponseEntity<List<String>>(
					listaUsers,
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
}
