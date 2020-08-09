package com.test.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {
	
	@NotNull(message = "{notnull}")
	@NotEmpty(message = "{notempty}")
	private String name;
	
	@NotNull(message = "{notnull}")
	private Long areaM2;
}
