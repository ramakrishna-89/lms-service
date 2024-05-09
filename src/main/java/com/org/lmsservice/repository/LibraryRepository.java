package com.org.lmsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.lmsservice.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
