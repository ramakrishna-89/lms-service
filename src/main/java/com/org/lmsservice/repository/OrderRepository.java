package com.org.lmsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.lmsservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
