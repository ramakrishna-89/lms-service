package com.org.lmsservice.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.lmsservice.dto.BookDto;
import com.org.lmsservice.dto.LibraryDto;
import com.org.lmsservice.dto.LibraryBookIdDto;
import com.org.lmsservice.entity.Book;
import com.org.lmsservice.entity.Library;
import com.org.lmsservice.repository.BookRepository;
import com.org.lmsservice.repository.LibraryRepository;
import com.org.lmsservice.service.iface.LibraryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class LibraryServiceImpl implements LibraryService {

	private LibraryRepository repository;
	private BookRepository bookRepository;

	@Override
	public LibraryDto create(LibraryDto dto) {
		Library entity = new Library();
		BeanUtils.copyProperties(dto, entity);
		BeanUtils.copyProperties(repository.save(entity), dto);
		return dto;
	}

	@Override
	public LibraryDto update(LibraryDto dto) throws Exception {
		return repository.findById(dto.getId()).map(entity -> {
			BeanUtils.copyProperties(dto, entity);
			BeanUtils.copyProperties(repository.save(entity), dto);
			return dto;
		}).orElseThrow(() -> new RuntimeException("ID Not available"));
	}

	@Override
	public LibraryDto read(Long id) throws Exception {
		return repository.findById(id).map(entity -> {
			LibraryDto dto = new LibraryDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).orElseThrow(() -> new RuntimeException("ID Not available"));
	}

	@Override
	public List<LibraryDto> readAll() throws Exception {
		return repository.findAll().stream().map(entity -> {
			LibraryDto dto = new LibraryDto();
			BeanUtils.copyProperties(entity, dto);
			List<BookDto> books = entity.getBooks().stream().map(bookEntity -> {
				BookDto bookDto = new BookDto();
				BeanUtils.copyProperties(bookEntity, bookDto);
				return bookDto;
			}).collect(Collectors.toList());
			dto.setBooks(books);
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public boolean delete(Long id) throws Exception {
		repository.deleteById(id);
		return true;
	}

	@Override
	public boolean linkBookToLibrary(LibraryBookIdDto dto) throws Exception {
		Book book = bookRepository.findById(dto.getBookId()).orElseThrow(() -> new RuntimeException("Book Not Found"));
		Library library = repository.findById(dto.getLibraryId())
				.orElseThrow(() -> new RuntimeException("Library Not Found"));
		book.setLibrary(library);
		bookRepository.save(book);
		return true;
	}

	@Override
	public List<BookDto> searchLibrary(String query) throws Exception {
		return bookRepository.findAll(bookRepository.searchSpec(query)).stream()
				.filter(bookEntity -> bookEntity.getLibrary() != null).map(bookEntity -> {
					BookDto dto = new BookDto();
					BeanUtils.copyProperties(bookEntity, dto);
					return dto;
				}).collect(Collectors.toList());
	}

	@Override
	public boolean checkoutBook(LibraryBookIdDto dto) throws Exception {
		Book book = bookRepository.findById(dto.getBookId()).orElseThrow(() -> new RuntimeException("Book Not Found"));
		book.setCheckoutDate(LocalDate.now());
		book.setAvailabilityStatus(false);
		Library library = repository.findById(dto.getLibraryId())
				.orElseThrow(() -> new RuntimeException("Library Not Found"));
		book.setLibrary(library);
		bookRepository.save(book);
		return true;
	}
	
	@Override
	public boolean returnBook(LibraryBookIdDto dto) throws Exception {
		Book book = bookRepository.findById(dto.getBookId()).orElseThrow(() -> new RuntimeException("Book Not Found"));
		book.setCheckoutDate(null);
		book.setAvailabilityStatus(true);
		Library library = repository.findById(dto.getLibraryId())
				.orElseThrow(() -> new RuntimeException("Library Not Found"));
		book.setLibrary(library);
		bookRepository.save(book);
		return true;
	}

	@Override
	public Integer calculateFine(Long libraryId, Long bookId) throws Exception {
		Book book = bookRepository.findById(libraryId).orElseThrow(() -> new RuntimeException("Book Not Found"));
		Library library = repository.findById(bookId).orElseThrow(() -> new RuntimeException("Library Not Found"));
		if (book.getCheckoutDate() != null) {
			return (Period.between(LocalDate.now(), book.getCheckoutDate()).getDays() * library.getOverdueFeesPerDay());
		}
		return 0;
	}

}
