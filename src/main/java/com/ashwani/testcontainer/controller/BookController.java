package com.ashwani.testcontainer.controller;

import com.ashwani.testcontainer.entity.Book;
import com.ashwani.testcontainer.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public Iterable<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return this.bookRepository.save(book);
    }
}
