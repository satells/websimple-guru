package com.simple.websimple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.websimple.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
