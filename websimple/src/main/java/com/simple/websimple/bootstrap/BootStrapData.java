package com.simple.websimple.bootstrap;

//https://www.baeldung.com/hibernate-unsaved-transient-instance-error
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.simple.websimple.domain.Author;
import com.simple.websimple.domain.Book;
import com.simple.websimple.domain.Publisher;
import com.simple.websimple.repository.AuthorRepository;
import com.simple.websimple.repository.BookRepository;
import com.simple.websimple.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	@Autowired
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Starting Bootstrap");

		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setCity("St Peterburg");
		publisher.setState("FL");
		publisherRepository.save(publisher);
		System.out.println("Publisher Count: " + publisherRepository.count());

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "123123");

		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);

		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "12345789");

		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(publisher);

		publisher.getBooks().add(noEJB);

		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);

		System.out.println("Started in Bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of authors: " + authorRepository.count());
		System.out.println("Publisher books; " + publisher.getBooks().size());
	}
}