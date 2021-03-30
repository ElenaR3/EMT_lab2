package com.emt.libraryemt.web;

import com.emt.libraryemt.model.Book;
import com.emt.libraryemt.model.enums.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoriesController {


    @GetMapping
    public List<BookCategory> getHomepage(){

        return Arrays.asList(BookCategory.values());
    }

}
