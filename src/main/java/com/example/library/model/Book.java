package com.example.library.model;

import java.time.LocalDate;

public class Book {
    private String id;
    private String name;
    private LocalDate date;
    private Author author;
    private BookStatus bookStatus;

    public Book() {}

    public Book(String id, String name, LocalDate date, Author author, BookStatus bookStatus) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
        this.bookStatus = bookStatus;
    }

    public Book(String name, LocalDate date, Author author, BookStatus bookStatus) {
        super();
        this.name = name;
        this.date = date;
        this.author = author;
        this.bookStatus = bookStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
