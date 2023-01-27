package org.example.library.service;

import org.example.library.api.BookRentData;
import org.example.library.model.Book;

import java.util.Optional;

public interface BookCheckerAvailable {
    Optional<Book> checkAndGetBook(BookRentData bookRentData);

}
