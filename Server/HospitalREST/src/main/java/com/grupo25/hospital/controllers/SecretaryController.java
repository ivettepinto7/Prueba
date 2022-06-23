package com.grupo25.hospital.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo25.hospital.models.dtos.ExpedienteDTO;
import com.grupo25.hospital.models.dtos.ExpedientePacienteDTO;
import com.grupo25.hospital.models.dtos.MessageDTO;
import com.grupo25.hospital.models.dtos.RestorePassDTO;
import com.grupo25.hospital.models.dtos.ScheduleAppointmentDTO;
import com.grupo25.hospital.models.dtos.UpdatePassDTO;
import com.grupo25.hospital.models.entities.Person;
import com.grupo25.hospital.services.PersonService;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
	
	@Autowired
	private PersonService personService;
	
	@PutMapping("/my-info/updatepassword")
	public ResponseEntity<?> updateOwnPassword(@Valid UpdatePassDTO newPassInfo, BindingResult result){
		
		try {
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				return new ResponseEntity<>(
						new MessageDTO("Errores en validacion" + errors),
						HttpStatus.BAD_REQUEST);
			}
			if(!newPassInfo.getNew_password().equals(newPassInfo.getConfirm_password())) {
				return new ResponseEntity<>(
						new MessageDTO("Contraseñas no son iguales"),
						HttpStatus.BAD_REQUEST);
			}
			Person foundPerson = personService.getPersonAuthenticated();
			if(personService.comparePassword(foundPerson, newPassInfo.getCurrent_password())==false) {
				return new ResponseEntity<>(
						new MessageDTO("Contraseña actual equivocada"),
						HttpStatus.BAD_REQUEST);
			}
			personService.updatePersonPassword(newPassInfo, foundPerson);
			return new ResponseEntity<>(
					new MessageDTO("Contraseña actualizada"),
					HttpStatus.OK
				);
			
		} catch (Exception e) {
			return new ResponseEntity<>(
					null,
					HttpStatus.INTERNAL_SERVER_ERROR
				);
		}
	}

	/*@GetMapping("/citas-dia")
	public ResponseEntity<List<CitasDiaDTO>> getDayAppointments(BindingResult result){
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
	public ResponseEntity<List<ExpedienteDTO>> getUserExpediente(ExpedientePacienteDTO expediente, BindingResult result){
		try {
			//TODO implementar logica de obtener usuarios
			List<ExpedienteDTO> listaExpediente= new ArrayList<>();
			return new ResponseEntity<List<ExpedienteDTO>>(
					listaExpediente,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/agendar-cita")
	public ResponseEntity<MessageDTO> bookAppointment(ScheduleAppointmentDTO nuevaCita,BindingResult result){
		try {
			//TODO implementar logica de reservar citas
			
			return new ResponseEntity<MessageDTO>(
					new MessageDTO("Reservada correctamente"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
}
