package com.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.dto.ApiResponseDto;
import com.test.dto.CustomException;
import com.test.util.ValidationMsgUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;


@RestControllerAdvice
public class ExceptionHandlerRestController {
	
	private static final Logger LOGGER = LogManager.getLogger(ExceptionHandlerRestController.class);

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ApiResponseDto<Object>> responseException(CustomException e)
	{
		ApiResponseDto<Object> dto = ApiResponseDto.builder()
				.message(e.getMessage())
				.trace(e.getStackTrace())
				.build();

		if(e.getStatus()!=null) {
			return new ResponseEntity<>(dto, e.getStatus());
		}
		return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponseDto<Object>> response(Exception e)
	{
		ApiResponseDto<Object> dto = ApiResponseDto.builder()
				.message(e.getMessage())
				.trace(e.getStackTrace())
				.build();
		LOGGER.error(e);
		return new ResponseEntity<>(dto, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<Object> respondDataAccessException(DataAccessException e) {
		LOGGER.error(e);
			return new ResponseEntity<>(new ApiResponseDto<>(null, e.getMessage(), e.getStackTrace()),
					HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		
		return new ResponseEntity<>(
				ValidationMsgUtil.convertToDto(ex.getBindingResult().getFieldErrors()),
				HttpStatus.BAD_REQUEST);
	}

}
