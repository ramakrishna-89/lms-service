package com.org.lmsservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column
	private Long id;
	
	@Column(nullable = false)
	private Long bookId;
	
	@Column(nullable = false)
	private Long LibraryId;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@Column(nullable = false)
	private Double price;
	
}
