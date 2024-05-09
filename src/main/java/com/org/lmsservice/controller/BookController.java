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

import com.org.lmsservice.dto.BookDto;
import com.org.lmsservice.service.iface.BookService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
@Slf4j
public class BookController {

	private BookService service;

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody @Valid BookDto dto, BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.info("BookController.create {}", result.getAllErrors());
				ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(service.create(dto));
		} catch (Exception e) {
			log.info("BookController.create {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping
	public ResponseEntity<Object> update(@RequestBody @Valid BookDto dto, BindingResult result) {
		try {
			if (result.hasErrors()) {
				log.info("BookController.update {}", result.getAllErrors());
				ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(service.create(dto));
		} catch (Exception e) {
			log.info("BookController.update {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public ResponseEntity<Object> readAll() {
		try {
			return ResponseEntity.ok(service.readAll());
		} catch (Exception e) {
			log.info("BookController.readAll {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> read(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.read(id));
		} catch (Exception e) {
			log.info("BookController.read {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(service.delete(id));
		} catch (Exception e) {
			log.info("BookController.delete {}", e);
			return ResponseEntity.badRequest().build();
		}
	}

}
