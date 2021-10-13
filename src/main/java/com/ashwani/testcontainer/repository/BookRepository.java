package com.ashwani.testcontainer.repository;

import com.ashwani.testcontainer.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
