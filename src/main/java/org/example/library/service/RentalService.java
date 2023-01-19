package org.example.library.service;

import org.example.library.api.RentedBooksData;
import org.example.library.dao.RentalBooksProvider;
import org.example.library.dao.RentalDao;
import org.example.library.model.Book;
import org.example.library.model.Rental;
import java.util.ArrayList;
import java.util.List;

public class RentalService implements RentalBooksDataGetter {
    private final int userId;
    private final RentalBooksProvider rentalBooksProvider;

    // BookDao class to add

    public RentalService(int userId) {
        this.userId = userId;
        this.rentalBooksProvider = new RentalDao();

        // Book Provider interface
    }

    public RentalService(int userId, RentalBooksProvider rentalBooksProvider) {
        this.userId = userId;
        this.rentalBooksProvider = rentalBooksProvider;
    }
    @Override
    public Book getBookByIdFromBookDAO(int bookId) { // as a parameter bookprovider interface
        return null;
        // Waiting for BookDao Class
    }

    public List<RentedBooksData> getRentedBooksData(){
        List<Rental> rentals = rentalBooksProvider.findRentedAllBooksByUser(userId);
        List<RentedBooksData> rentedBooksData = new ArrayList<>();
        for (Rental rental : rentals) {
            rentedBooksData.add(new RentedBooksData(
                    this.getBookByIdFromBookDAO(rental.getId()).getTitle()
                    , rental.getRentDate()
                    , rental.getDueDate()));
        }

        return rentedBooksData;
    }
}
