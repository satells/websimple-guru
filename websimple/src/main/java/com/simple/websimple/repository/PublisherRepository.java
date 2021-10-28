package com.simple.websimple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.websimple.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
