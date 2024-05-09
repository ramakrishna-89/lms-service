package com.org.lmsservice.service.iface;

import java.util.List;

import com.org.lmsservice.dto.OrderDto;

public interface OrderService {

	OrderDto create(OrderDto dto);

	OrderDto update(OrderDto dto) throws Exception;

	OrderDto read(Long id) throws Exception;

	List<OrderDto> readAll() throws Exception;

	boolean delete(Long id) throws Exception;

}
