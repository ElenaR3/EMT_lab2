package com.emt.libraryemt.repository;

import com.emt.libraryemt.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByAuthorName(String name);
}
