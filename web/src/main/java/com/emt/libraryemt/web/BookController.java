package com.emt.libraryemt.web;

import com.emt.libraryemt.model.Author;
import com.emt.libraryemt.model.Book;
import com.emt.libraryemt.model.dto.BookDto;
import com.emt.libraryemt.service.AuthorService;
import com.emt.libraryemt.service.impl.BookServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {

    private final BookServiceImpl bookService;
    private final AuthorService authorService;

    public BookController(BookServiceImpl bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Book> getHomepage(){

        List<Book> books = this.bookService.findAll();
        return books;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {

        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {

        Author author = new Author(bookDto.getAuthor());

        Book book = new Book(bookDto.getName(), author, bookDto.getAvailableCopies(), bookDto.getBookCategory());
        return this.bookService.save(book)
                .map(book1 -> ResponseEntity.ok().body(book1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDto bookDto) {

        Author author = null;
        Optional<Book> findBook = this.bookService.findById(id);

        if (findBook.isPresent()) {
            author =findBook.get().getAuthor();
        }
        return this.bookService.edit(id, bookDto.getName(), author,
                bookDto.getAvailableCopies(), bookDto.getBookCategory())
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteBook(id);
        if(this.bookService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
