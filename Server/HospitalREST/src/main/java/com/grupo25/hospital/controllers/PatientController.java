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

import com.grupo25.hospital.models.dtos.InmunizationsDTO;
import com.grupo25.hospital.models.dtos.MessageDTO;
import com.grupo25.hospital.models.dtos.PrevAppointmentDTO;
import com.grupo25.hospital.models.dtos.RemindersDTO;
import com.grupo25.hospital.models.dtos.RestorePassDTO;
import com.grupo25.hospital.models.dtos.ScheduleAppointmentDTO;
import com.grupo25.hospital.models.dtos.TestListDTO;
import com.grupo25.hospital.models.dtos.UpdatePassDTO;
import com.grupo25.hospital.models.dtos.UserPrescriptionDTO;
import com.grupo25.hospital.models.entities.Area;
import com.grupo25.hospital.models.entities.Person;
import com.grupo25.hospital.services.AreaService;
import com.grupo25.hospital.services.PersonService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private AreaService areaService;
	@Autowired
	private PersonService personService;
	
	@GetMapping("/areas")
	public ResponseEntity<?> getAllAreas(){
		try {
			List<Area> areas = areaService.findAll();
			
			return new ResponseEntity<>(
						areas,
						HttpStatus.OK
					);
		} catch (Exception e) {
			return new ResponseEntity<>(
						null,
						HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PostMapping("/agendar-cita")
	public ResponseEntity<?> bookAppointment(ScheduleAppointmentDTO newSchedule,BindingResult result){
		try {
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				return new ResponseEntity<>(
						new MessageDTO("Errores en validacion" + errors),
						HttpStatus.BAD_REQUEST);
			}
			Person foundPerson = personService.getPersonAuthenticated();
			
			///////////////////Id de doctor se asigna hasta que el doctor atiende a la persona
			
			
			return new ResponseEntity<MessageDTO>(
					new MessageDTO("Reservada correctamente"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
	
	
	/*@GetMapping("/expediente/inmunizaciones")
	public ResponseEntity<List<InmunizationsDTO>> getInmunizations(GetEntityDTO user,BindingResult result){
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
	public ResponseEntity<List<TestListDTO>> getDoneTests(GetEntityDTO user, BindingResult result){
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
	public ResponseEntity<List<UserPrescriptionDTO>> getPrescriptions(GetEntityDTO user, BindingResult result){
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
	public ResponseEntity<List<PrevAppointmentDTO>> getPreviousAppointments(GetEntityDTO user, BindingResult result){
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
	
	@PostMapping("/agendar-cita")
	public ResponseEntity<MessageDTO> bookAppointment(ScheduleAppointmentDTO newSchedule,BindingResult result){
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
	public ResponseEntity<List<RemindersDTO>> getRecordatorios(GetEntityDTO user, BindingResult result){
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
	}*/
}
