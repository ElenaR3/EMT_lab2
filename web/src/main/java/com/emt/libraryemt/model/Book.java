package com.emt.libraryemt.model;

import com.emt.libraryemt.model.enums.BookCategory;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade=CascadeType.ALL)
    private Author author;

    private Integer availableCopies;

    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

    public Book() {
    }

    public Book(String name, Author author, Integer availableCopies, BookCategory bookCategory) {
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.bookCategory = bookCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}
