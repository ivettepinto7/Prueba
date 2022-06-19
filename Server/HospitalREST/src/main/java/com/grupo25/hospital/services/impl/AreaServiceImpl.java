package com.grupo25.hospital.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo25.hospital.models.entities.Area;
import com.grupo25.hospital.repositories.AreaRepository;
import com.grupo25.hospital.services.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaRepository areaRepository;

	@Override
	public Area findOneById(Long id) throws Exception {
		return areaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Area> findAll() throws Exception {
		return areaRepository.findAll();
	}

}
