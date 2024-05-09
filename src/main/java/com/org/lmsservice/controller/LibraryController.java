package com.org.lmsservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.lmsservice.dto.LibraryDto;
import com.org.lmsservice.dto.LibraryBookIdDto;
import com.org.lmsservice.service.iface.LibraryService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/library")
@AllArgsConstructor
@Slf4j
public class LibraryController {

	private LibraryService service;

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid LibraryDto dto, BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.info("LibraryController.create {}", result.getAllErrors());
				ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(service.create(dto));
		} catch (Exception e) {
			log.info("LibraryController.create {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody @Valid LibraryDto dto, BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.info("LibraryController.update {}", result.getAllErrors());
				ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(service.create(dto));
		} catch (Exception e) {
			log.info("LibraryController.update {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public ResponseEntity<Object> readAll() {
		try {
			return ResponseEntity.ok(service.readAll());
		} catch (Exception e) {
			log.info("LibraryController.readAll {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> read(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.read(id));
		} catch (Exception e) {
			log.info("LibraryController.read {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.delete(id));
		} catch (Exception e) {
			log.info("LibraryController.delete {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/link-book-to-library")
	public ResponseEntity<Object> addBookToLibrary(@RequestBody @Valid LibraryBookIdDto dto, BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.info("LibraryController.update {}", result.getAllErrors());
				ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(service.linkBookToLibrary(dto));
		} catch (Exception e) {
			log.info("LibraryController.update {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/get-library-catalog")
	public ResponseEntity<Object> getLibraryCatalog() {
		try {
			return ResponseEntity.ok(service.readAll());
		} catch (Exception e) {
			log.info("LibraryController.readAll {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/search-library/{query}")
	public ResponseEntity<Object> searchLibrary(@PathVariable String query) {
		try {
			return ResponseEntity.ok(service.searchLibrary(query));
		} catch (Exception e) {
			log.info("LibraryController.readAll {}", e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/checkout-book")
	public ResponseEntity<Object> checkoutBook(@RequestBody @Valid LibraryBookIdDto dto, BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.info("LibraryController.checkoutBook {}", result.getAllErrors());
				ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(service.checkoutBook(dto));
		} catch (Exception e) {
			log.info("LibraryController.checkoutBook {}", e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/return-book")
	public ResponseEntity<Object> returnBook(@RequestBody @Valid LibraryBookIdDto dto, BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.info("LibraryController.returnBook {}", result.getAllErrors());
				ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(service.returnBook(dto));
		} catch (Exception e) {
			log.info("LibraryController.returnBook {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/calculate-fine/{libraryId}/{bookId}")
	public ResponseEntity<Object> calculateFine(@PathVariable Long libraryId, @PathVariable Long bookId) {
		try {
			return ResponseEntity.ok(service.calculateFine(libraryId, bookId));
		} catch (Exception e) {
			log.info("LibraryController.calculateFine {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

}
