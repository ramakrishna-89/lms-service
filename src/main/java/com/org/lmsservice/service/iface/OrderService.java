package com.org.lmsservice.service.iface;

import java.util.List;

import com.org.lmsservice.dto.BookOrderDto;

public interface OrderService {

	BookOrderDto create(BookOrderDto dto);

	BookOrderDto update(BookOrderDto dto) throws Exception;

	BookOrderDto read(Long id) throws Exception;

	List<BookOrderDto> readAll() throws Exception;

	boolean delete(Long id) throws Exception;

}
