package org.example.library.view;

import org.example.library.api.RentedBooksData;
import org.example.library.controller.RentalController;
import java.util.Scanner;
import java.util.Set;

public class RentedBooksView implements View {
    private final RentalController rentalController;
    private final Scanner scanner;

    public RentedBooksView() {
        this.rentalController = new RentalController();
        this.scanner = new Scanner(System.in);
    }

    public RentedBooksView(RentalController rentalController) {
        this.rentalController = rentalController;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void display() {
        Set<RentedBooksData> rentals = rentalController.rentals();
        if (!rentals.isEmpty()) {
            rentals.forEach(System.out::println);
        } else {
            System.out.println("You don't have to return any books");
        }
        System.out.println("\n\n\nPress Enter key to continue...");
        scanner.nextLine();
        new MainMenuView().display();
    }
}
