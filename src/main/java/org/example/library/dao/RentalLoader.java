package org.example.library.dao;

import org.example.library.model.Book;
import org.example.library.model.User;

public interface RentalLoader {
    void addBookToRentalList(Book book, User user);
}
