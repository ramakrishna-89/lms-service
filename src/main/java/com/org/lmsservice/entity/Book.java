	package com.org.lmsservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String isbnId;

	@Column(nullable = false)
	private String bookName;

	@Column(nullable = false)
	private String author;

	@Column(nullable = false)
	private String genre;
	
	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private boolean availabilityStatus;

	@Column
	@Temporal(TemporalType.DATE)
	private LocalDate checkoutDate;

	@ManyToOne
	@JoinColumn(name = "library_id", nullable = true)
	private Library library;

}
