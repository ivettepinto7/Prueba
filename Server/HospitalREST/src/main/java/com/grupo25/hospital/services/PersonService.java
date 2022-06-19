package com.grupo25.hospital.services;

import java.util.List;

import com.grupo25.hospital.models.dtos.CreatePersonDTO;
import com.grupo25.hospital.models.entities.Area;
import com.grupo25.hospital.models.entities.Person;
import com.grupo25.hospital.models.entities.Role;

public interface PersonService {
	void register(CreatePersonDTO personInfo, Role role, Area area) throws Exception;
	Person findOneById(Long id) throws Exception;
	Person findOneByIdentifier(String username) throws Exception;
	List<Person> findAll() throws Exception;
	Boolean comparePassword(Person person, String passToCompare) throws Exception;
	void insertToken(Person person, String token) throws Exception;
	Boolean isTokenValid(Person person, String token) throws Exception;
	Person getPersonAuthenticated() throws Exception;
}