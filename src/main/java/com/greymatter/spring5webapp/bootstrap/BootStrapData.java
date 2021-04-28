package com.greymatter.spring5webapp.bootstrap;

import com.greymatter.spring5webapp.domain.Author;
import com.greymatter.spring5webapp.domain.Book;
import com.greymatter.spring5webapp.domain.Publisher;
import com.greymatter.spring5webapp.repositories.AuthorRepository;
import com.greymatter.spring5webapp.repositories.BookRepository;
import com.greymatter.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("Lima");
        publisher.setState("FL");
        publisherRepository.save(publisher);

        Author jorge = new Author("jorge", "carlos");
        Book ddd = new Book("Domain Driven Design","11252445");
        jorge.getBooks().add(ddd);
        ddd.getAuthors().add(jorge);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(jorge);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author ken= new Author("ken", "jhonson");
        Book noEjb = new Book("J2EE Development whithout EJB", "1232324444");
        ken.getBooks().add(noEjb);
        noEjb.getAuthors().add(ken);
        noEjb.setPublisher(publisher);
        publisher.getBooks().add(noEjb);

        authorRepository.save(ken);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap!!!!!");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publisher Number of book " + publisher.getBooks().size());


    }
}
