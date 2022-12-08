package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repo.BookRepo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLibraryService {
    private BookRepo bookRepo;

    public BookLibraryService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getBooksFromService(){
        return bookRepo.getBooksFromRepo();
    }

    public Book getBookFromServiceByIsbn(int isbn) {
        return bookRepo.getBookFromRepoByIsbn(isbn);
    }

    public Book safeBooksService(int isbn, Book book){
       return bookRepo.safeBookRepo(isbn, book);
    }

    public Book deleteBookService(int isbn){
       return bookRepo.deleteBookRepo(isbn);
    }
}

