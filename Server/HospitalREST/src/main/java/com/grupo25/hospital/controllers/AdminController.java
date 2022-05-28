package com.grupo25.hospital.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo25.hospital.models.dtos.AreasDTO;
import com.grupo25.hospital.models.dtos.DrugsExistenceDTO;
import com.grupo25.hospital.models.dtos.MessageDTO;
import com.grupo25.hospital.models.dtos.TestListDTO;
import com.grupo25.hospital.models.dtos.UserDTO;
import com.grupo25.hospital.models.dtos.VaccinesExistenceListDTO;

@RestController
@RequestMapping("")
public class AdminController {
	

	@GetMapping("/usuarios")
	public ResponseEntity<List<UserDTO>> getUsers(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener usuarios
			List<UserDTO> listaUsers= new ArrayList<>();
			return new ResponseEntity<List<UserDTO>>(
					listaUsers,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/usuarios/crear")
	public ResponseEntity<MessageDTO> createUser(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de registrar usuario
			return new ResponseEntity<>(
					new MessageDTO("Usuario registrado"),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/usuarios/modificar")
	public ResponseEntity<MessageDTO> modifyUser(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar usuario
			return new ResponseEntity<>(
					new MessageDTO("Usuario modificado"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/usuarios/eliminar")
	public ResponseEntity<MessageDTO> eliminarUser(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar usuario
			return new ResponseEntity<>(
					new MessageDTO("Usuario eliminado"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/examenes")
	public ResponseEntity<List<TestListDTO>> getTests(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de obtener examenes
			List<TestListDTO> TestList= new ArrayList<>();
			return new ResponseEntity<List<TestListDTO>>(
					TestList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/examenes/crear")
	public ResponseEntity<MessageDTO> createTest(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de crear test
			return new ResponseEntity<>(
					new MessageDTO("Examen creado"),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/examenes/modificar")
	public ResponseEntity<MessageDTO> modifyTest(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar test
			return new ResponseEntity<>(
					new MessageDTO("Examen modificado"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/examenes/eliminar")
	public ResponseEntity<MessageDTO> deleteTest(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar usuario
			return new ResponseEntity<>(
					new MessageDTO("Examen eliminado"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/vacunas")
	public ResponseEntity<List<VaccinesExistenceListDTO>> getVaccines(/*ELDTO, */ BindingResult result){
		try {
		List<VaccinesExistenceListDTO> VaccinesList= new ArrayList<>();
		return new ResponseEntity<List<VaccinesExistenceListDTO>>(
				VaccinesList,
				HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@PostMapping("/vacunas/crear")
	public ResponseEntity<MessageDTO> createVaccine(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de crear Vaccine
			return new ResponseEntity<>(
					new MessageDTO("Vacuna creada"),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/vacunas/modificar")
	public ResponseEntity<MessageDTO> modifyVaccine(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar test
			return new ResponseEntity<>(
					new MessageDTO("Vacuna modificada"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/vacunas/eliminar")
	public ResponseEntity<MessageDTO> deleteVacuna(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar usuario
			return new ResponseEntity<>(
					new MessageDTO("Vacuna eliminada"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/areas")
	public ResponseEntity<List<AreasDTO>> getAreas(/*ELDTO, */ BindingResult result){
		try {
		List<AreasDTO> AreasList= new ArrayList<>();
		return new ResponseEntity<List<AreasDTO>>(
				AreasList,
				HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@PostMapping("/areas/crear")
	public ResponseEntity<MessageDTO> createAreas(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de crear Vaccine
			return new ResponseEntity<>(
					new MessageDTO("Area creada"),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/areas/modificar")
	public ResponseEntity<MessageDTO> modifyArea(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar test
			return new ResponseEntity<>(
					new MessageDTO("Area modificada"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/areas/eliminar")
	public ResponseEntity<MessageDTO> deleteArea(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar usuario
			return new ResponseEntity<>(
					new MessageDTO("Area eliminada"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/medicamentos")
	public ResponseEntity<List<DrugsExistenceDTO>> getMedicamentos(/*ELDTO, */ BindingResult result){
		try {
		List<DrugsExistenceDTO> MedicamentosList= new ArrayList<>();
		return new ResponseEntity<List<DrugsExistenceDTO>>(
				MedicamentosList,
				HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	@PostMapping("/medicamentos/crear")
	public ResponseEntity<MessageDTO> createDrug(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de crear Vaccine
			return new ResponseEntity<>(
					new MessageDTO("Medicamento creado"),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/medicamentos/modificar")
	public ResponseEntity<MessageDTO> modifyDrug(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar test
			return new ResponseEntity<>(
					new MessageDTO("Medicamento modificado"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/medicamentos/eliminar")
	public ResponseEntity<MessageDTO> deleteDrug(/*ELDTO, */ BindingResult result){
		try {
			//TODO implementar logica de modificar usuario
			return new ResponseEntity<>(
					new MessageDTO("Medicamento eliminado"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
