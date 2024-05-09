package com.org.lmsservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

	private Long id;

	@NotNull
	private Long bookId;

	@NotNull
	private Long LibraryId;

	@NotNull
	private Integer quantity;

	@NotNull
	private Double price;

}
