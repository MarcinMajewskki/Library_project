package org.example.library.service;

import org.example.library.model.Book;

public interface RentalBooksDataGetter {

    public Book getBookByIdFromBookDAO(int bookId);
}

