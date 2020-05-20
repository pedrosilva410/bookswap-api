package com.bookswap.http.controllers;

import com.bookswap.http.models.Book;
import com.bookswap.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/account/{accountId}/books")
    public ResponseEntity<Void> createBook(@RequestBody Book book, @PathVariable("accountId") String accountId){
        var newBook = bookService.createBook(book);
        return ResponseEntity.created(getBookResourceURI(newBook.getId())).build();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable("bookId")String bookId) {
        return bookService.getBook(bookId);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getBooks();
    }

    private URI getBookResourceURI(String id){
        return URI.create(String.format("/books/%s", id));
    }
}
