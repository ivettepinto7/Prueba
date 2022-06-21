package com.grupo25.hospital.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grupo25.hospital.models.dtos.ActualizarPassDTO;
import com.grupo25.hospital.models.dtos.CreatePersonDTO;
import com.grupo25.hospital.models.dtos.IniciarSesionDTO;
import com.grupo25.hospital.models.dtos.LoginDTO;
import com.grupo25.hospital.models.dtos.MessageDTO;
import com.grupo25.hospital.models.dtos.RecuperarPassDTO;
import com.grupo25.hospital.models.dtos.TokenDTO;
import com.grupo25.hospital.models.entities.Area;
import com.grupo25.hospital.models.entities.Person;
import com.grupo25.hospital.models.entities.Role;
import com.grupo25.hospital.services.AreaService;
import com.grupo25.hospital.services.PersonService;
import com.grupo25.hospital.services.RoleService;
import com.grupo25.hospital.utils.TokenManager;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	private TokenManager tokenManager;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AreaService areaService;
	
	@PostMapping("/signin")
	@ResponseBody
	public ResponseEntity<TokenDTO> login(@Valid LoginDTO loginInfo, BindingResult result){
		try {
			if(result.hasErrors()) {
	            return new ResponseEntity<>(
	                    new TokenDTO(),
	                    HttpStatus.BAD_REQUEST
	                );
	        }
			
			Person person = personService.findOneByIdentifier(loginInfo.getUsername());
			//Role role = person.getId_role();
			//Area area = person.getId_area();
			
			if(personService.comparePassword(person, loginInfo.getPassword()) == false) {
	            return new ResponseEntity<>(
	                    new TokenDTO(),
	                    HttpStatus.UNAUTHORIZED
	                );
	        }
			
	        
	        final String token = tokenManager.generateJwtToken(person.getUsername());
	        
	        personService.insertToken(person, token);
	        
	        return new ResponseEntity<TokenDTO>(
                    new TokenDTO(
                    		token,
                    		person.getId_person(),
                    		person.getName(),
                    		person.getUsername(),
                    		person.getLast_name(),
                    		person.getEmail(),
                    		person.getGender(),
                    		person.getStatus(),
                    		person.getBirthdate()
                    	),
                    HttpStatus.CREATED
                );
	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
	        return new ResponseEntity<>(
	                new TokenDTO(),
	                HttpStatus.INTERNAL_SERVER_ERROR
	            );
		}
	}
	
	/*@PostMapping("recuperarcontra")
	public ResponseEntity<MessageDTO> recoverPassword(RecuperarPassDTO recuperarPass,BindingResult result){
		try {
			//TODO implementar logica de recuperar contra
			return new ResponseEntity<>(
					new MessageDTO("Usuario registrado"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	/*@PostMapping("iniciarsesion")
	private ResponseEntity<TokenDTO> login( IniciarSesionDTO iniciarSesion,BindingResult result){
		try {
			//TODO crear token
			String token="";
			return new ResponseEntity<>(
                    new TokenDTO(token),
                    HttpStatus.OK
                );
			
		} catch (Exception e) {
			return new ResponseEntity<>(
					new TokenDTO(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}*/
	
	//@PostMapping("cerrarsesion")
	//private ResponseEntity<MessageDTO> logout(/*EL DTO*/ BindingResult result){
		//try {
			//TODO logica de cerrado de sesion
			//return new ResponseEntity<>(
                    //HttpStatus.CREATED
                //);
			
		//} catch (Exception e) {
			//return new ResponseEntity<>(
					//HttpStatus.INTERNAL_SERVER_ERROR);
		//}
	//}
	
	/*@PostMapping("actualizarcontra")
	public ResponseEntity<MessageDTO> updatePassword(ActualizarPassDTO updatepass,BindingResult result){
		try {
			//TODO implementar logica de actualizar password
			return new ResponseEntity<>(
					new MessageDTO("Actualizada"),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new MessageDTO("Error interno"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
}