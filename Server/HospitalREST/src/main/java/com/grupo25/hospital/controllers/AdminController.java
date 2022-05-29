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
import com.grupo25.hospital.models.dtos.CreateAreaDTO;
import com.grupo25.hospital.models.dtos.CreateDrugDTO;
import com.grupo25.hospital.models.dtos.CreateTestDTO;
import com.grupo25.hospital.models.dtos.CreateUserDTO;
import com.grupo25.hospital.models.dtos.CreateVaccineDTO;
import com.grupo25.hospital.models.dtos.GetEntityDTO;
import com.grupo25.hospital.models.dtos.DrugsExistenceDTO;
import com.grupo25.hospital.models.dtos.EditAreaDTO;
import com.grupo25.hospital.models.dtos.EditDrugDTO;
import com.grupo25.hospital.models.dtos.EditTestDTO;
import com.grupo25.hospital.models.dtos.EditUserDTO;
import com.grupo25.hospital.models.dtos.EditVaccineDTO;
import com.grupo25.hospital.models.dtos.ExamExistenceDTO;
import com.grupo25.hospital.models.dtos.MessageDTO;
import com.grupo25.hospital.models.dtos.TestListDTO;
import com.grupo25.hospital.models.dtos.UserDTO;
import com.grupo25.hospital.models.dtos.VaccinesExistenceListDTO;

@RestController
@RequestMapping("")
public class AdminController {
	

	@GetMapping("/usuarios")
	public ResponseEntity<List<UserDTO>> getUsers(UserDTO usuario, BindingResult result){
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
	public ResponseEntity<MessageDTO> createUser(CreateUserDTO newUser ,BindingResult result){
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
	public ResponseEntity<MessageDTO> modifyUser(EditUserDTO editedUser ,BindingResult result){
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
	public ResponseEntity<MessageDTO> eliminarUser(GetEntityDTO newDelete ,BindingResult result){
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
	public ResponseEntity<List<ExamExistenceDTO>> getTests(ExamExistenceDTO exam, BindingResult result){
		try {
			//TODO implementar logica de obtener examenes
			List<ExamExistenceDTO> TestList= new ArrayList<>();
			return new ResponseEntity<List<ExamExistenceDTO>>(
					TestList,
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/examenes/crear")
	public ResponseEntity<MessageDTO> createTest(CreateTestDTO newTest ,BindingResult result){
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
	public ResponseEntity<MessageDTO> modifyTest(EditTestDTO editTest, BindingResult result){
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
	public ResponseEntity<MessageDTO> deleteTest(GetEntityDTO newDelete,BindingResult result){
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
	public ResponseEntity<List<VaccinesExistenceListDTO>> getVaccines(VaccinesExistenceListDTO vaccine, BindingResult result){
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
	public ResponseEntity<MessageDTO> createVaccine(CreateVaccineDTO newVaccine ,BindingResult result){
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
	public ResponseEntity<MessageDTO> modifyVaccine(EditVaccineDTO editVaccine ,BindingResult result){
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
	public ResponseEntity<MessageDTO> deleteVacuna( GetEntityDTO newDelete ,BindingResult result){
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
	public ResponseEntity<List<AreasDTO>> getAreas(AreasDTO areas,BindingResult result){
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
	public ResponseEntity<MessageDTO> createAreas(CreateAreaDTO newArea ,BindingResult result){
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
	public ResponseEntity<MessageDTO> modifyArea(EditAreaDTO editArea,BindingResult result){
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
	public ResponseEntity<MessageDTO> deleteArea(GetEntityDTO newDelete ,BindingResult result){
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
	public ResponseEntity<List<DrugsExistenceDTO>> getMedicamentos(DrugsExistenceDTO drugs,BindingResult result){
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
	public ResponseEntity<MessageDTO> createDrug(CreateDrugDTO newDrug, BindingResult result){
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
	public ResponseEntity<MessageDTO> modifyDrug(EditDrugDTO editDrug,BindingResult result){
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
	public ResponseEntity<MessageDTO> deleteDrug(GetEntityDTO newDelete ,BindingResult result){
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
