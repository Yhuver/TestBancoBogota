package com.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDto<T> {

	private T data;
	private String message;
	private StackTraceElement[] trace;
	public ApiResponseDto(T data) {
		this.data = data;
	}

	public ApiResponseDto(T data, String message) {
		this.data = data;
		this.message = message;
	}


	public static ApiResponseDto<String> ok() {
		return ApiResponseDto.<String>builder()
				.data("")
				.message("success")
				.build();
	}


	public static <T> ApiResponseDto<T> ok(T data) {
		return ApiResponseDto.<T>builder()
				.data(data)
				.message("success")
				.build();
	}

}