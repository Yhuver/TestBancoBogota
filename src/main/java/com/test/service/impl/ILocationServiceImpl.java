package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.controller.model.ILocationDao;
import com.test.dto.LocationDto;
import com.test.service.ILocationService;

@Service
public class ILocationServiceImpl implements ILocationService{

	@Autowired
	private ILocationDao locationDao;
	
	@Override
	public List<LocationDto> listLocations() {
		
		return null;
	}

	@Override
	public void createLocation(LocationDto location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLocation(Long idLocation) {
		// TODO Auto-generated method stub
		
	}

}
