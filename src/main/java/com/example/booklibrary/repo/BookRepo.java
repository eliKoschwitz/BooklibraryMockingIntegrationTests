package com.example.booklibrary.repo;

import com.example.booklibrary.model.Book;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Data
@Repository
@NoArgsConstructor
public class BookRepo {
    private List<Book> books = new ArrayList<>(List.of(new Book(12314, "Harry Potter", "J.K"), new Book(12345, "Book of Eli", "Jesus")));

    public List<Book> getBooksFromRepo() {
        return books;
    }

    /*
    //Constructor
    public BookRepo(List<Book> books) {
        this.books = books;
    }
     */

    public Book getBookFromRepoByIsbn(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                return book;
            }
        }
        throw new NoSuchElementException("Book is not in lib");
    }

    public Book safeBookRepo(int isbn, Book book) {
        boolean flag = true;
        for (Book currentBook : books) {
            if (currentBook.getIsbn() == isbn) {
                currentBook.setAutor(book.getAutor());
                //currentBook.setIsbn(book.getIsbn());
                currentBook.setTitle(book.getTitle());
                flag = false;
            }
        }
        if (flag == true) {
            books.add(book);
            return book;
        }
        return null;
    }

    public boolean deleteBookRepo(int isbn){
        for (Book currentBook : books) {
            if (currentBook.getIsbn() == isbn) {
                return books.remove(currentBook);
            }
            throw new NoSuchElementException("Book is not in the Lib");

        }
        return false;
    }
}


