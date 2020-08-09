package com.test.service;

import java.util.List;

import com.test.dto.LocationDto;
import com.test.entity.Location;

public interface ILocationService {
	
	List<Location> listLocations();
	
	void createLocation(LocationDto location);
	
	void deleteLocation(Long idLocation);

	Location getId(Long idLocation);
}
