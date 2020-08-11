package com.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.test.TestBancoBogotaApplication;
import com.test.dto.LocationDto;
import com.test.entity.Location;
import com.test.service.ILocationService;


@SpringBootTest(classes = { TestBancoBogotaApplication.class }, properties = "spring.profiles.active=test")
public class LocationControllerUT {

private static final String RESOURCE_PATH = "/api/v1/location";
	
	private MockMvc mockMvc;
	
	@InjectMocks
    private LocationController locationController;
	
	@MockBean
	private ILocationService locationServiceImpl;
	
	private Location location1;
	private Location location2;
	private LocationDto locationDto1;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
                .standaloneSetup(locationController)
                .build();
		
		location1 = Location.builder().
		name("Apatamento1").
		areaM2(25l).build();
		
		location2 = Location.builder().
				name("Apatamento2").
				areaM2(30l).build();
		
		locationDto1 = LocationDto.builder().
				name("Apatamento3").
				areaM2(15l).build();
	}
	
	@Test
	public void create() throws Exception {
		
		String serviceInJson = "{\r\n" + 
				"\"name\":\"Apatamento1\",\r\n" + 
				"\"areaM2\":30\r\n" + 
				"}";
		
		final ResultActions result = this.mockMvc.perform(post(RESOURCE_PATH)
				.content(serviceInJson)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print());
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.message").value("success"));
		
	}

	
}
