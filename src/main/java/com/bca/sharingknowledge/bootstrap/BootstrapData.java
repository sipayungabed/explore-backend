package com.bca.sharingknowledge.bootstrap;

import com.bca.sharingknowledge.domain.Author;
import com.bca.sharingknowledge.domain.Book;
import com.bca.sharingknowledge.repository.AuthorRepository;
import com.bca.sharingknowledge.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("abed", "nego");
        Book book = new Book("menulis", "12345678");
        book.getAuthor().add(author);
        author.getBook().add(book);
        Author author1 = new Author("abi", "gail");
        Book book1 = new Book("membaca", "987654321");

        authorRepository.save(author);
        bookRepository.save(book);
        authorRepository.save(author1);
        bookRepository.save(book1);

        System.out.println("total jumlah buku :" + bookRepository.count());

    }
}
