package com.grupo25.hospital.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo25.hospital.models.dtos.MessageDTO;
import com.grupo25.hospital.models.dtos.TokenDTO;

@RestController
@RequestMapping("/")
public class AuthController {
	
	//UserService
	
	//TokenManager
	
	@PostMapping("recuperarcontra")
	public ResponseEntity<MessageDTO> recoverPassword(/*ELDTO, */ BindingResult result){
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
	}
	
	@PostMapping("iniciarsesion")
	private ResponseEntity<TokenDTO> login(/*EL DTO*/ BindingResult result){
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
		}
	
	@PostMapping("cerrarsesion")
	private ResponseEntity<MessageDTO> logout(/*EL DTO*/ BindingResult result){
		try {
			//TODO logica de cerrado de sesion
			return new ResponseEntity<>(
                    HttpStatus.CREATED
                );
			
		} catch (Exception e) {
			return new ResponseEntity<>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	@PostMapping("actualizarcontra")
	public ResponseEntity<MessageDTO> updatePassword(/*ELDTO, */ BindingResult result){
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
	}
	
	
	}


