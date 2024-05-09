package com.org.lmsservice.dto;

import java.util.List;

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
public class LibraryDto {

	private Long id;

	@NotNull
	@NotBlank
	private String name;

	@NotNull
	private Integer maxDaysToReturnBook;

	@NotNull
	private Integer checkoutFees;

	@NotNull
	private Integer overdueFeesPerDay;

	private List<BookDto> books;

}
