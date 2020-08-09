package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.controller.model.ILocationDao;
import com.test.dto.LocationDto;
import com.test.entity.Location;
import com.test.service.ILocationService;

@Service
public class ILocationServiceImpl implements ILocationService {

	@Autowired
	private ILocationDao locationDao;

	@Override
	public List<Location> listLocations() {
		return locationDao.findAll();
	}

	@Override
	public void createLocation(LocationDto location) {
		locationDao.save(Location.builder().areaM2(location.getAreaM2()).name(location.getName()).build());
	}

	@Override
	public void deleteLocation(Long idLocation) {
		locationDao.delete(this.getId(idLocation));
	}

	@Override
	public Location getId(Long idLocation) {
		Optional<Location> opt=locationDao.findById(idLocation);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new com.test.dto.CustomException("No se encontro esta localización", HttpStatus.NOT_FOUND);
		}
	}

}
