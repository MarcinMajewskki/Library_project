package org.example.library;

import org.example.library.controller.RentalController;
import org.example.library.view.LoginView;
import org.example.library.view.RentedBooksView;
import org.example.library.view.View;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        View view = new LoginView(Optional.empty());
        view.display();
        View viewRental = new RentedBooksView();
        viewRental.display();

}
}
