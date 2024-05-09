package com.org.lmsservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryBookIdDto {

	@NotNull
	private Long bookId;

	@NotNull
	private Long libraryId;

}
