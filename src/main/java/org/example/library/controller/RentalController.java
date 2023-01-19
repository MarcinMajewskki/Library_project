package org.example.library.controller;

import org.example.library.ApplicationContext;
import org.example.library.api.RentedBooksData;
import org.example.library.service.RentalService;
import org.example.library.view.MainMenuView;
import org.example.library.view.RentedBooksView;
import org.example.library.view.View;

import java.util.List;
import java.util.Optional;

public class RentalController {
     private final RentalService rentalService;

   public RentalController(){
//        this.rentalService = new RentalService(ApplicationContext.getActiveUser().getId()); // FOR TEST PURPOSES
            this.rentalService = new RentalService(1);
  }

    public RentalController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    public View rentals() {
        List<RentedBooksData> rentals = rentalService.getRentedBooksData();
        if (rentals.isEmpty()) {
            return new RentedBooksView(Optional.of("Nothing"));
//            return new MainMenuView(Optional.of("You don't have any books to return :)"));
}
            return new RentedBooksView(Optional.of(rentals.toString()));
    }
}
