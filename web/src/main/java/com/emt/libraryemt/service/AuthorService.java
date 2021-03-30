package com.emt.libraryemt.service;

import com.emt.libraryemt.model.Author;

import java.util.Optional;


public interface AuthorService {
    Optional<Author> findAuthorByName(String name);
}
