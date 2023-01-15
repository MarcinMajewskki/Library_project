package org.example.library.dao;

import org.example.library.model.Book;

import java.util.List;

public interface BookProvider {
    List<Book> findAvailableBooks();
}
