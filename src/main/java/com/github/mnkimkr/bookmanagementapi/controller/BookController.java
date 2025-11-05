package com.github.mnkimkr.bookmanagementapi.controller;

import com.github.mnkimkr.bookmanagementapi.model.Book;
import com.github.mnkimkr.bookmanagementapi.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* BookController handles HTTP requests related to books
*
* This is the entry point for the API layer, exposing RESTful endpoints
* It delegates all business logic to the BookService class
* */
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // Constructor Injection of BookService
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get /books
    // Retrieves a list of all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // POST /books
    // Adds a new book to the collection
    // the Request body is automatically converted from Jason into a book object
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
}
