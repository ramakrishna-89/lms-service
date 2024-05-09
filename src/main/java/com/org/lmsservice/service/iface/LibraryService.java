package com.org.lmsservice.service.iface;

import java.util.List;

import com.org.lmsservice.dto.BookDto;
import com.org.lmsservice.dto.LibraryDto;
import com.org.lmsservice.dto.LibraryBookIdDto;

public interface LibraryService {

	LibraryDto create(LibraryDto dto);

	LibraryDto update(LibraryDto dto) throws Exception;

	LibraryDto read(Long id) throws Exception;

	List<LibraryDto> readAll() throws Exception;

	boolean delete(Long id) throws Exception;

	boolean linkBookToLibrary(LibraryBookIdDto dto) throws Exception;

	List<BookDto> searchLibrary(String query) throws Exception;
	
	Integer calculateFine(Long libraryId, Long bookId) throws Exception;
	
	boolean checkoutBook(LibraryBookIdDto dto) throws Exception;
	
	boolean returnBook(LibraryBookIdDto dto) throws Exception;

}
