package org.example.library.view;

import org.example.library.controller.RentalController;
import java.util.Optional;

public class RentedBooksView implements View {
    private final RentalController rentalController;
    private final Optional<String> message;

    public RentedBooksView() {
        this.message = Optional.empty();
        this.rentalController = new RentalController();
    }

    public RentedBooksView(RentalController rentalController) {
        this.rentalController = rentalController;
        this.message = Optional.empty();
    }
    public RentedBooksView(Optional<String> message) {
        this.message = message;
        this.rentalController = new RentalController();
    }
    public RentedBooksView(RentalController rentalController, Optional<String> message) {
        this.rentalController = rentalController;
        this.message = message;
    }


    @Override
    public void display()  {
        rentalController.rentals().display();
    }
}
