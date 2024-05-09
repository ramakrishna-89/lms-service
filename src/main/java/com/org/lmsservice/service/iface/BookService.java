package com.org.lmsservice.service.iface;

import java.util.List;

import com.org.lmsservice.dto.BookDto;

public interface BookService {

	BookDto create(BookDto dto);

	BookDto update(BookDto dto) throws Exception;

	BookDto read(Long id) throws Exception;

	List<BookDto> readAll() throws Exception;

	boolean delete(Long id) throws Exception;
	
}
