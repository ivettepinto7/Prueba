package com.grupo25.hospital.services;

import java.util.List;

import com.grupo25.hospital.models.entities.Area;

public interface AreaService {
	Area findOneById(Long id) throws Exception;
	List<Area> findAll() throws Exception;
}
