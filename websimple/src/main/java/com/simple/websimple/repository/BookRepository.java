package com.simple.websimple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.websimple.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
