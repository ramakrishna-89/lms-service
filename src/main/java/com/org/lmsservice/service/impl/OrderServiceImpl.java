package com.org.lmsservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.lmsservice.dto.BookOrderDto;
import com.org.lmsservice.entity.BookOrder;
import com.org.lmsservice.repository.OrderRepository;
import com.org.lmsservice.service.iface.OrderService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

	private OrderRepository repository;

	@Override
	public BookOrderDto create(BookOrderDto dto) {
		BookOrder entity = new BookOrder();
		BeanUtils.copyProperties(dto, entity);
		BeanUtils.copyProperties(repository.save(entity), dto);
		return dto;
	}

	@Override
	public BookOrderDto update(BookOrderDto dto) throws Exception {
		return repository.findById(dto.getId()).map(entity -> {
			BeanUtils.copyProperties(dto, entity);
			BeanUtils.copyProperties(repository.save(entity), dto);
			return dto;
		}).orElseThrow(() -> new RuntimeException("ID Not available"));
	}

	@Override
	public BookOrderDto read(Long id) throws Exception {
		return repository.findById(id).map(entity -> {
			BookOrderDto dto = new BookOrderDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).orElseThrow(() -> new RuntimeException("ID Not available"));
	}

	@Override
	public List<BookOrderDto> readAll() throws Exception {
		return repository.findAll().stream().map(entity -> {
			BookOrderDto dto = new BookOrderDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public boolean delete(Long id) throws Exception {
		repository.deleteById(id);
		return true;
	}

}
