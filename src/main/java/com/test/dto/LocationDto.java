package com.test.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
	
	@NotNull(message = "{notnull}")
	@NotEmpty(message = "{notempty}")
	private String name;
	
	@NotNull(message = "{notnull}")
	private Long areaM2;
}
