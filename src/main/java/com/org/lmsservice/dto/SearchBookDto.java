package com.org.lmsservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchBookDto {

	@NotNull
	@NotBlank
	private String searchField;

	@NotNull
	@NotBlank
	private String searchString;

}
