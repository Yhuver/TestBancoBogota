package com.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.ApiResponseDto;
import com.test.dto.LocationDto;
import com.test.service.impl.ILocationServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("location")
public class LocationController {
	
	@Autowired
	private ILocationServiceImpl locationService;
	
	@GetMapping()
	public ApiResponseDto<List<LocationDto>> getCriteriaListToSelect(){
		
		return ApiResponseDto.<List<LocationDto>>builder()
				.data(locationService.listLocations())
				.message("success")
				.build();
	}
	
	@PostMapping
	public ApiResponseDto<String> create(@RequestBody(required = true) LocationDto location){
		locationService.createLocation(location);
		return ApiResponseDto.<String>builder()
				.data("")
				.message("success")
				.build();
	}
	
	@DeleteMapping
	public ApiResponseDto<String> create(@RequestHeader(required = true) Long idLocation){
		locationService.deleteLocation(idLocation);
		return ApiResponseDto.<String>builder()
				.data("")
				.message("success")
				.build();
	}

}
