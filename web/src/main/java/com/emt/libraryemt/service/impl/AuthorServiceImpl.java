package com.emt.libraryemt.service.impl;

import com.emt.libraryemt.model.Author;
import com.emt.libraryemt.repository.AuthorRepository;
import com.emt.libraryemt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findAuthorByName(String name) {
        return this.authorRepository.findByAuthorName(name);
    }
}
