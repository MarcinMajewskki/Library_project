package org.example.library.dao;

import org.example.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookProvider {
    List<Book> findAvailableBooks();
    Optional<Book> checkIfBookIsAvailable(Integer isbn);
    void changeAmountOfBook(Integer isbn);
}
