package com.emt.libraryemt.service;

import com.emt.libraryemt.model.Author;
import com.emt.libraryemt.model.Book;
import com.emt.libraryemt.model.dto.BookDto;
import com.emt.libraryemt.model.enums.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();
    Optional<Book> save(BookDto productDto);
    Optional<Book> save(Book book);
    Optional<Book> edit(Long id, String name, Author author,
                        Integer quantity, BookCategory bookCategory);
    Optional<Book> deleteBook(Long id);
    Optional<Book> markAsTaken(Long id);
    Optional<Book> findById(Long id);
}
