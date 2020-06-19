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

    public Book createBook(Book newBook, String userId){

        //create new book
        var entity = new BookEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setTitle(newBook.getTitle());
        entity.setDescription(newBook.getDescription());
        entity.setLocation(newBook.getLocation());
        entity.setGenres(newBook.getGenres());
        entity.setImage(newBook.getImage());
        entity.setUser(userId);


        // save book
        var saveEntity = this.bookRepository.save(entity);
        return new Book(saveEntity.getId(), saveEntity.getTitle(), saveEntity.getDescription(), saveEntity.getLocation(), saveEntity.getGenres(), saveEntity.getImage(), saveEntity.getUser());
    }

    /*public Book editBook(String bookId, Book newBookDetails){

        Book storedBookDetails = getBook(bookId);

        storedBookDetails.setTitle(newBookDetails.getTitle());
        storedBookDetails.setDescription(newBookDetails.getDescription());
        storedBookDetails.setGenres(newBookDetails.getGenres());
        storedBookDetails.setLocation(newBookDetails.getLocation());

        return storedBookDetails;
    }*/

    public String deleteBook(String bookId){
        bookRepository.deleteById(bookId);
        return "Successfully deleted the book";
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

    public List<Book> getBooksByTitle( String title){
        List<Book> books = new ArrayList<>();
        var dbBooks = bookRepository.findAll();
        for(BookEntity dbBook : dbBooks){
            if(dbBook.getTitle().contains(title)) {
                books.add(mapFromBookEntity(dbBook));
            }
        }
        return books;
    }



    public List<Book> getUserBooks(String accountId){
        List<Book> books = new ArrayList<>();
        var dbBooks = bookRepository.findAll();
        for(BookEntity dbBook : dbBooks){
            if(dbBook.getUser().equals(accountId)) {
                books.add(mapFromBookEntity(dbBook));
            }
        }
        return books;
    }

    private Book mapFromBookEntity(BookEntity bookEntity){
        return new Book(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getDescription(), bookEntity.getLocation(), bookEntity.getGenres(), bookEntity.getImage(), bookEntity.getUser());
    }
}