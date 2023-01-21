package org.example.library.controller;

import org.example.library.api.RentedBooksData;
import org.example.library.model.User;
import org.example.library.service.RentalService;
import java.util.Set;

public class RentalController {
    private final RentalService rentalService;

    public RentalController() {
        this.rentalService = new RentalService();
    }

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    public Set<RentedBooksData> rentals() {
        return rentalService.getRentedBooksData();
    }
}
