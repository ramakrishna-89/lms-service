package com.org.lmsservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

	private Long id;

	@NotNull
	@NotBlank
	private String isbnId;

	@NotNull
	@NotBlank
	private String bookName;

	@NotNull
	@NotBlank
	private String author;

	@NotNull
	@NotBlank
	private String genre;

	private boolean availabilityStatus;

}
