package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.service.BookLibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myapi")
public class BookLibraryController {
    private final BookLibraryService bookLibraryService;

    public BookLibraryController(BookLibraryService bookLibraryService) {
        this.bookLibraryService = bookLibraryService;
    }

    @GetMapping("/books")
    public List<Book> getBooks (){
        return bookLibraryService.getBooksFromService();
    }

    @GetMapping("/books/{isbn}")
    public Book getBooks (@PathVariable int isbn){
        return bookLibraryService.getBookFromServiceByIsbn(isbn);
    }

    @PutMapping("/books/{isbn}")
    public List<Book> safeBook (@PathVariable int isbn, @RequestBody Book book){
        bookLibraryService.safeBooksService(isbn,book);
        return bookLibraryService.getBooksFromService();
    }

    @DeleteMapping("/books/{isbn}")
    public List<Book> deleteBook(@PathVariable int isbn){
        bookLibraryService.deleteBookService(isbn);
        return bookLibraryService.getBooksFromService();
    }

}
