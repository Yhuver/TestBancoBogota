package com.test.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {

	private String name;
	
	private Long areaM2;
}
