package com.example.booklibrary.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
//@Component wieso darf das keine Component werden ?
public class Book {
    private int isbn;
    private String title;
    private String autor;
    //cover als enum!?


    public Book(int isbn, String title, String autor) {
        this.isbn = isbn;
        this.title = title;
        this.autor = autor;
    }

}
