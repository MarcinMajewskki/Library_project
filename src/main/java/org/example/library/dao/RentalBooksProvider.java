package org.example.library.dao;

import org.example.library.model.Book;
import org.example.library.model.Rental;
import org.example.library.model.User;

import java.util.List;
import java.util.Optional;

public interface RentalBooksProvider {

    List<Rental>  findRentedAllBooksByUser(int id);
}
