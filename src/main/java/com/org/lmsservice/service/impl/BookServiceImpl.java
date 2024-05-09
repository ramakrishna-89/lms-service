package com.org.lmsservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.lmsservice.dto.BookDto;
import com.org.lmsservice.entity.Book;
import com.org.lmsservice.repository.BookRepository;
import com.org.lmsservice.service.iface.BookService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {

	private BookRepository repository;

	@Override
	public BookDto create(BookDto dto) {
		Book entity = new Book();
		BeanUtils.copyProperties(dto, entity);
		BeanUtils.copyProperties(repository.save(entity), dto);
		return dto;
	}

	@Override
	public BookDto update(BookDto dto) throws Exception {
		return repository.findById(dto.getId()).map(entity -> {
			BeanUtils.copyProperties(dto, entity);
			BeanUtils.copyProperties(repository.save(entity), dto);
			return dto;
		}).orElseThrow(() -> new RuntimeException("ID Not available"));
	}

	@Override
	public BookDto read(Long id) throws Exception {
		return repository.findById(id).map(entity -> {
			BookDto dto = new BookDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).orElseThrow(() -> new RuntimeException("ID Not available"));
	}

	@Override
	public List<BookDto> readAll() throws Exception {
		return repository.findAll().stream().map(entity -> {
			BookDto dto = new BookDto();
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
