package org.example.library.dao;

import org.example.library.model.Rental;
import java.util.List;

public interface RentalBooksProvider {

    List<Rental>  findRentedAllBooksByUser(int id);
}
