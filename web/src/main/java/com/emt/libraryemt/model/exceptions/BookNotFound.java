package com.emt.libraryemt.model.exceptions;

import java.util.function.Supplier;

public class BookNotFound extends RuntimeException{

    public BookNotFound() {
        super("A book with the given id doesn't exist");
    }
}

