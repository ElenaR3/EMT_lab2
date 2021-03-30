package com.emt.libraryemt.service.impl;
import com.emt.libraryemt.model.Author;
import com.emt.libraryemt.model.Book;
import com.emt.libraryemt.model.dto.BookDto;
import com.emt.libraryemt.model.enums.BookCategory;
import com.emt.libraryemt.model.exceptions.BookNotFound;
import com.emt.libraryemt.repository.BookRepository;
import com.emt.libraryemt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {

        String authorName = bookDto.getAuthor();
        Author author = new Author(authorName);
        BookCategory bookCategory = bookDto.getBookCategory();
        Book book = new Book(bookDto.getName(), author, bookDto.getAvailableCopies(), bookCategory);
        Book savedBook = this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> save(Book book) {
        Book savedBook = this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Author author, Integer quantity, BookCategory bookCategory) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFound::new);
        book.setName(name);
        book.setAuthor(author);
        book.setAvailableCopies(quantity);
        book.setBookCategory(bookCategory);

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    public Optional<Book> deleteBook(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFound::new);
        this.bookRepository.delete(book);
        return Optional.of(book);

    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(BookNotFound::new);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

}
