package com.bca.sharingknowledge.repository;

import com.bca.sharingknowledge.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
