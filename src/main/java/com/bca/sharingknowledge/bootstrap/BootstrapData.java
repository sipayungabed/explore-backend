package com.bca.sharingknowledge.bootstrap;

import com.bca.sharingknowledge.domain.Author;
import com.bca.sharingknowledge.domain.Book;
import com.bca.sharingknowledge.domain.Publisher;
import com.bca.sharingknowledge.repository.AuthorRepository;
import com.bca.sharingknowledge.repository.BookRepository;
import com.bca.sharingknowledge.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;


    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher1 = new Publisher("gramedia", "pagedangan, no 1", "tangerang", "11111", "banten");
        publisherRepository.save(publisher1);

        Author author = new Author("abed", "nego");
        Book book = new Book("menulis", "12345678");
        book.getAuthor().add(author);
        author.getBooks().add(book);
        book.setPublisher(publisher1);
        authorRepository.save(author);
        bookRepository.save(book);

        Author author1 = new Author("abi", "gail");
        Book book1 = new Book("membaca", "987654321");
        publisher1.getBooks().add(book);
        publisher1.getBooks().add(book1);
        authorRepository.save(author1);
        book1.setPublisher(publisher1);
        bookRepository.save(book1);

        System.out.println("total jumlah book :" + bookRepository.count());
        System.out.println("total buku dalam publisher 1: " + publisher1.getBooks().size());

    }
}
