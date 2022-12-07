package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repo.BookRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookLibraryServiceTest {

    // Mit Mocking
    BookRepo mockRepo = mock(BookRepo.class);
    @Test
    void getBooksFromServiceShouldReturnAList() {
        // GIVEN
        BookLibraryService bookLibraryService = new BookLibraryService(mockRepo);
        //when(mockRepo.getBooksFromRepo()).thenReturn(new ArrayList<>(List.of(new Book(12314, "Harry Potter", "J.K"), new Book(12345, "Book of Eli", "Jesus"),new Book(123456, "Book of Miau", "Katze"))));
        when(mockRepo.getBooksFromRepo()).thenReturn(new ArrayList<>(List.of(new Book(12314, "Harry Potter", "J.K"), new Book(12345, "Book of Eli", "Jesus"))));

        // WHEN
        List<Book> actual = bookLibraryService.getBooksFromService();
        // THEN
        Assertions.assertEquals(new ArrayList<>(List.of(new Book(12314, "Harry Potter", "J.K"), new Book(12345, "Book of Eli", "Jesus"))),actual);
    }


    @Test
    void getBookFromServiceByIsbn() {
    }
}