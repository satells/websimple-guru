package com.simple.websimple.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.simple.websimple.domain.Author;
import com.simple.websimple.repository.AuthorRepository;
import com.simple.websimple.repository.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("Eric", "Evans");

	}

}
