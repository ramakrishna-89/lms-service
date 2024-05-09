package com.org.lmsservice.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.org.lmsservice.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

	default Specification<Book> searchSpec( String searchValue) {
		return (root, query, builder) -> {
			return builder.or(
					builder.like(builder.upper(root.get("bookName")), "%" + searchValue.toUpperCase() + "%"),
					builder.like(builder.upper(root.get("author")), "%" + searchValue.toUpperCase() + "%"));
		};
	}

}
