package com.org.lmsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.lmsservice.entity.BookOrder;

@Repository
public interface OrderRepository extends JpaRepository<BookOrder, Long> {

}
