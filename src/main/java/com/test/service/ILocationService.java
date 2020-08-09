package com.test.service;

import java.util.List;

import com.test.dto.LocationDto;

public interface ILocationService {
	
	List<LocationDto> listLocations();
	
	void createLocation(LocationDto location);
	
	void deleteLocation(Long idLocation);

}
