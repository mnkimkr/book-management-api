package com.github.mnkimkr.bookmanagementapi.service;

import com.github.mnkimkr.bookmanagementapi.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/*
* BookService class handles the business logic for managing books.
* */
@Service
public class BookService {

    // Stores the list of books in memory
    private final List<Book> books = new ArrayList<>();
    // Generates unique IDs for each book
    private final AtomicLong counter = new AtomicLong(1);


    /*
    * Returns all books in the system
    *
    * @return a list of all books
    * */
    public List<Book> getAllBooks() {
        return books;
    }

    /*
    * Add a new book to the list
    *
    * @param book the new book to be added
    * @return the added book with its new ID
    * */
    public Book addBook(Book book){
        book.setId(counter.getAndIncrement());
        books.add(book);
        return book;
    }


    // Find a book with an ID
    public Optional<Book> getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    // Update
    public Optional<Book> updateBook(Long id, Book updatedBook) {
        return getBookById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setYear(updatedBook.getYear());
            return book;
        });
    }

    // Delete
    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }

}
