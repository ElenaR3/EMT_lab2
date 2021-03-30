package com.emt.libraryemt.model.dto;

import com.emt.libraryemt.model.Author;
import com.emt.libraryemt.model.enums.BookCategory;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
public class BookDto {

    private String name;

    @ManyToOne
    private String author;

    private Integer availableCopies;

    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

    public BookDto() {
    }

    public BookDto(String name, String author, Integer availableCopies, BookCategory bookCategory) {
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.bookCategory = bookCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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
