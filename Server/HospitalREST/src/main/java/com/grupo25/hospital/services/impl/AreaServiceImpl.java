package com.grupo25.hospital.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo25.hospital.models.dtos.CreateAreaDTO;
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

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void insert(CreateAreaDTO areaInfo) throws Exception {
		Area area = new Area();
		
		area.setName(areaInfo.getName());
		area.setGender(areaInfo.getGender());
		area.setStart_age(areaInfo.getStart_age());
		area.setFrequency(areaInfo.getFrequency());
		
		areaRepository.save(area);
	}

	@Override
	public Area findOneByIdentifier(String name) throws Exception {
		return areaRepository.findByName(name);
	}

}
