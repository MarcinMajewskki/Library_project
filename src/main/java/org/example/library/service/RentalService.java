package org.example.library.service;

import org.example.library.ApplicationContext;
import org.example.library.api.RentedBooksData;
import org.example.library.dao.RentalDao;
import org.example.library.model.Book;
import org.example.library.model.Rental;
import java.util.List;

public class RentalService implements RentalBooksDataGetter {
    private static List<RentedBooksData> rentedBooksData;
    private static RentalDao rentalDao = new RentalDao();
    private static List<Rental> rentals;
    public RentalService() {
        rentals = rentalDao.findRentedAllBooksByUser(ApplicationContext.getActiveUser().getId());
        rentals.forEach(rental -> getBooksByIdFromBookDAO(rental.getId()));
    }
    // szuka w DAO books id
    // wysyła books id, get Books
    // zwraca books przerabia i zwraca rentedBooksdata

    @Override
    public List<Book> getBooksByIdFromBookDAO(int bookId) {
        return null; // List of Books from BookDao selected by book id.
    }
}
