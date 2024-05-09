package com.org.lmsservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.lmsservice.dto.OrderDto;
import com.org.lmsservice.entity.Order;
import com.org.lmsservice.repository.OrderRepository;
import com.org.lmsservice.service.iface.OrderService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

	private OrderRepository repository;

	@Override
	public OrderDto create(OrderDto dto) {
		Order entity = new Order();
		BeanUtils.copyProperties(dto, entity);
		BeanUtils.copyProperties(repository.save(entity), dto);
		return dto;
	}

	@Override
	public OrderDto update(OrderDto dto) throws Exception {
		return repository.findById(dto.getId()).map(entity -> {
			BeanUtils.copyProperties(dto, entity);
			BeanUtils.copyProperties(repository.save(entity), dto);
			return dto;
		}).orElseThrow(() -> new RuntimeException("ID Not available"));
	}

	@Override
	public OrderDto read(Long id) throws Exception {
		return repository.findById(id).map(entity -> {
			OrderDto dto = new OrderDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).orElseThrow(() -> new RuntimeException("ID Not available"));
	}

	@Override
	public List<OrderDto> readAll() throws Exception {
		return repository.findAll().stream().map(entity -> {
			OrderDto dto = new OrderDto();
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
