package org.example.library.service;

import org.example.library.model.Book;
import java.util.List;


public interface RentalBooksDataGetter {

    public List<Book> getBooksByIdFromBookDAO(int id);
}

