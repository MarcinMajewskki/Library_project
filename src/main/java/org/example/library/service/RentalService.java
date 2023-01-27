package org.example.library.service;

import org.example.library.api.BookRentData;
import org.example.library.dao.BookProvider;
import org.example.library.model.Book;

import java.util.Optional;

public class RentalService implements BookCheckerAvailable {
    private final BookProvider bookProvider;

    public RentalService(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    @Override
    public Optional<Book> checkAndGetBook(BookRentData bookRentData) {
        return bookProvider.checkIfBookIsAvailable(bookRentData.getIsbn());
    }
}
