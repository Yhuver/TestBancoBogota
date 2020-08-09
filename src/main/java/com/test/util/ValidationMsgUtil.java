package com.test.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

import com.test.dto.ApiResponseDto;
import com.test.dto.MsgValidationDto;



public final class ValidationMsgUtil {
	
	public static List<MsgValidationDto> convert(List<FieldError> listFields) {
		
		List<MsgValidationDto> listResp = new ArrayList<>();
		
		for (FieldError fieldError : listFields) {
			listResp.add(
					new MsgValidationDto(fieldError.getField(),
							fieldError.getDefaultMessage().replace("#", fieldError.getField()))
					);
		}

		return listResp;
		
	}
	
	public static ApiResponseDto<List<MsgValidationDto>> convertToDto(List<FieldError> listFields) {
		return ApiResponseDto.<List<MsgValidationDto>>builder()
		  .data(convert(listFields))
		  .message("invalid data")
		  .build();
	}

}
