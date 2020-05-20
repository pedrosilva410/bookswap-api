package com.bookswap.services;

import com.bookswap.data.entities.BookEntity;
import com.bookswap.data.repositories.BookRepository;
import com.bookswap.http.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book newBook){

        //create new book
        var entity = new BookEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setTitle(newBook.getTitle());
        entity.setDescription(newBook.getDescription());
        entity.setLocation(newBook.getLocation());
        entity.setGenres(newBook.getGenres());
        entity.setImage(newBook.getImage());


        // save book
        var saveEntity = this.bookRepository.save(entity);
        return new Book(saveEntity.getId(), saveEntity.getTitle(), saveEntity.getDescription(), saveEntity.getLocation(), saveEntity.getGenres(), saveEntity.getImage());
    }

    public Book getBook(String id){
        return bookRepository.findById(id).map(this::mapFromBookEntity).get();
    }

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        var dbBooks = bookRepository.findAll();
        for(BookEntity dbBook : dbBooks){
            books.add(mapFromBookEntity(dbBook));
        }
        return books;
    }

    private Book mapFromBookEntity(BookEntity bookEntity){
        return new Book(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getDescription(), bookEntity.getLocation(), bookEntity.getGenres(), bookEntity.getImage());
    }
}