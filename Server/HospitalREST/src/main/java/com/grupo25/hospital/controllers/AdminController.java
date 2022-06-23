package com.grupo25.hospital.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo25.hospital.models.dtos.UpdatePassDTO;
import com.grupo25.hospital.models.dtos.CreateAreaDTO;
import com.grupo25.hospital.models.dtos.CreatePersonDTO;
import com.grupo25.hospital.models.dtos.CreateVaccineDTO;
import com.grupo25.hospital.models.dtos.EditAreaDTO;
import com.grupo25.hospital.models.dtos.EditPersonDTO;
import com.grupo25.hospital.models.dtos.EditVaccineDTO;
import com.grupo25.hospital.models.dtos.MessageDTO;
import com.grupo25.hospital.models.dtos.PersonResponseDTO;
import com.grupo25.hospital.models.entities.Area;
import com.grupo25.hospital.models.entities.Person;
import com.grupo25.hospital.models.entities.Role;
import com.grupo25.hospital.models.entities.Vaccine;
import com.grupo25.hospital.services.AreaService;
import com.grupo25.hospital.services.MailService;
import com.grupo25.hospital.services.PersonService;
import com.grupo25.hospital.services.RoleService;
import com.grupo25.hospital.services.VaccineService;
import com.grupo25.hospital.utils.TokenManager;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private TokenManager tokenManager;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private VaccineService vaccService;
	
	@GetMapping("/users")
	public ResponseEntity<?> findAllPeople(){
		try {
			List<Person> people = personService.findAll();
			
			return new ResponseEntity<>(
						people,
						HttpStatus.OK
					);
		} catch (Exception e) {
			return new ResponseEntity<>(
						null,
						HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> findOnePerson(@PathVariable(name = "id") Long id){
		try {
			Person foundPerson = personService.findOneById(id);

			if(foundPerson != null) {
				return new ResponseEntity<>(
						new PersonResponseDTO(foundPerson.getEmail(), foundPerson.getStatus(), foundPerson.getUsername()),
						HttpStatus.OK
					);
			}
			
			return new ResponseEntity<>(
					new PersonResponseDTO(),
					HttpStatus.NOT_FOUND
				);
			
		} catch (Exception e) {
			return new ResponseEntity<>(
						null,
						HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PostMapping("/users/create")
	public ResponseEntity<?> registerUser(@Valid CreatePersonDTO personInfo, BindingResult result){
		try {
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				return new ResponseEntity<>(
						new MessageDTO("Errores en validacion" + errors),
						HttpStatus.BAD_REQUEST);
			}
			
			Person foundPerson = personService.findOneByIdentifier(personInfo.getUsername());
			
			if(foundPerson != null) {
				return new ResponseEntity<>(
						new MessageDTO("Esta persona ya existe"),
						HttpStatus.BAD_REQUEST);
			}
			
			mailService.sendWelcomeEmail(personInfo.getEmail(), personInfo.getUsername());
			
			Role foundRole = roleService.findOneById(personInfo.getRole());
			
			if(personInfo.getArea() == null) {
				System.out.println("FOUND ROLE " + foundRole.getName());
				personService.register(personInfo, foundRole, null);
				return new ResponseEntity<>(
						new MessageDTO("Persona registrada"),
						HttpStatus.CREATED);
			}else {
				Area foundArea = areaService.findOneById(personInfo.getArea());
				
				personService.register(personInfo, foundRole, foundArea);
				
				return new ResponseEntity<>(
						new MessageDTO("Persona registrada"),
						HttpStatus.CREATED);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PutMapping("/users/update")
	public ResponseEntity<?> editUser(@Valid EditPersonDTO personInfo, BindingResult result){
		try {
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				return new ResponseEntity<>(
						new MessageDTO("Errores en validacion" + errors),
						HttpStatus.BAD_REQUEST);
			}
			
			Person foundPerson = personService.findOneById(personInfo.getId());
			
			if(foundPerson != null) {
				personService.update(personInfo, foundPerson);
				
				return new ResponseEntity<>(
						new MessageDTO("Persona actualizada"),
						HttpStatus.OK
					);
			}
			
			return new ResponseEntity<>(
					new MessageDTO("Persona no encontrada"),
					HttpStatus.NOT_FOUND
				);
		} catch(Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PutMapping("/users/{id}/deactivate")
	public ResponseEntity<?> deactivateUser(@PathVariable(name = "id") Long id){
		try {
			Person foundPerson = personService.findOneById(id);
			
			if(foundPerson != null) {
				Boolean status = foundPerson.getStatus();
				personService.deactivate(foundPerson, status);
				return new ResponseEntity<>(
						new MessageDTO("Persona actualizada"),
						HttpStatus.OK
					);
			}
			
			return new ResponseEntity<>(
					new MessageDTO("Persona no encontrada"),
					HttpStatus.NOT_FOUND
				);
			
		} catch (Exception e) {
			return new ResponseEntity<>(
						null,
						HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
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
	
	@PostMapping("/areas/create")
	public ResponseEntity<?> createArea(@Valid CreateAreaDTO areaInfo, BindingResult result){
		try {
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				return new ResponseEntity<>(
						new MessageDTO("Errores en validacion" + errors),
						HttpStatus.BAD_REQUEST);
			}
			
			Area foundArea = areaService.findOneByIdentifier(areaInfo.getName());
			
			if(foundArea != null) {
				return new ResponseEntity<>(
						new MessageDTO("Esta área ya existe"),
						HttpStatus.BAD_REQUEST);
			}
			
			areaService.insert(areaInfo);
			
			return new ResponseEntity<>(
					new MessageDTO("Área registrada"),
					HttpStatus.CREATED
					);
			
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PutMapping("/areas/update")
	public ResponseEntity<?> updateArea(@Valid EditAreaDTO areaInfo, BindingResult result){
		try {
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				return new ResponseEntity<>(
						new MessageDTO("Errores en validacion" + errors),
						HttpStatus.BAD_REQUEST);
			}
			
			Area foundArea = areaService.findOneById(areaInfo.getId());
			
			if(foundArea != null) {
				/*Area existArea = areaService.findOneByIdentifier(areaInfo.getName());
				
				if(existArea != null) {
					return new ResponseEntity<>(
							new MessageDTO("Está area ya existe"),
							HttpStatus.BAD_REQUEST
							);
				}*/
				
				areaService.update(areaInfo, foundArea);
				return new ResponseEntity<>(
						new MessageDTO("Área actualizada"),
						HttpStatus.OK
					);
			}
			
			return new ResponseEntity<>(
					new MessageDTO("Área no encontrada"),
					HttpStatus.NOT_FOUND
				);
			
		} catch (Exception e) {
			return new ResponseEntity<>(
						null,
						HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@DeleteMapping("/areas/{id}/delete")
	public ResponseEntity<?> deleteArea(@PathVariable(name = "id") Long id){
		try {
			Area foundArea = areaService.findOneById(id);
			
			if(foundArea != null) {
				areaService.delete(foundArea);
				
				return new ResponseEntity<>(
						new MessageDTO("Área eliminada"),
						HttpStatus.OK
					);
			}
			
			return new ResponseEntity<>(
					new MessageDTO("Área no encontrada"),
					HttpStatus.NOT_FOUND
				);
		} catch(Exception e) {
			return new ResponseEntity<>(
					null,
					HttpStatus.INTERNAL_SERVER_ERROR
				);
		}
	}
	
	@GetMapping("/vaccines")
	public ResponseEntity<?> getAllVaccines(){
		try {
			List<Vaccine> vaccines = vaccService.findAll();
			
			return new ResponseEntity<>(
						vaccines,
						HttpStatus.OK
					);
		} catch (Exception e) {
			return new ResponseEntity<>(
						null,
						HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PostMapping("/vaccines/create")
	public ResponseEntity<?> createVaccine(@Valid CreateVaccineDTO vaccInfo, BindingResult result){
		try {
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				return new ResponseEntity<>(
						new MessageDTO("Errores en validacion" + errors),
						HttpStatus.BAD_REQUEST);
			}
			
			Vaccine vacc = vaccService.findOneByIdentifier(vaccInfo.getName());
			
			if(vacc != null) {
				return new ResponseEntity<>(
						new MessageDTO("Esta vacuna ya existe"),
						HttpStatus.BAD_REQUEST
						);
			}
			
			vaccService.insert(vaccInfo);
			
			return new ResponseEntity<>(
					new MessageDTO("Vacuna registrada"),
					HttpStatus.CREATED
					);
			
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@PutMapping("/vaccines/update")
	public ResponseEntity<?> updateVaccine(@Valid EditVaccineDTO vaccInfo, BindingResult result){
		try {
			if(result.hasErrors()) {
				String errors = result.getAllErrors().toString();
				return new ResponseEntity<>(
						new MessageDTO("Errores en validacion" + errors),
						HttpStatus.BAD_REQUEST);
			}
			
			Vaccine foundVacc = vaccService.findOneById(vaccInfo.getId());
			
			if(foundVacc != null) {
				vaccService.update(vaccInfo, foundVacc);
				return new ResponseEntity<>(
						new MessageDTO("Vacuna actualizada"),
						HttpStatus.OK
					);
			}
			
			return new ResponseEntity<>(
					new MessageDTO("Vacuna no encontrada"),
					HttpStatus.NOT_FOUND
				);
			
		} catch (Exception e) {
			return new ResponseEntity<>(
						null,
						HttpStatus.INTERNAL_SERVER_ERROR
					);
		}
	}
	
	@DeleteMapping("/vaccines/{id}/delete")
	public ResponseEntity<?> deleteVaccine(@PathVariable(name = "id") Long id){
		try {
			Vaccine foundVacc = vaccService.findOneById(id);
			
			if(foundVacc != null) {
				vaccService.delete(foundVacc);
				
				return new ResponseEntity<>(
						new MessageDTO("Vacuna eliminada"),
						HttpStatus.OK
					);
			}
			
			return new ResponseEntity<>(
					new MessageDTO("Vacuna no encontrada"),
					HttpStatus.NOT_FOUND
				);
		} catch(Exception e) {
			return new ResponseEntity<>(
					null,
					HttpStatus.INTERNAL_SERVER_ERROR
				);
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
	

	/*
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
	}*/
	
	
	
}
