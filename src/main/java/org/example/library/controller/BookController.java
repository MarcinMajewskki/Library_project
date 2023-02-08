package org.example.library.controller;


import org.example.library.api.BookRentData;
import org.example.library.dao.BookDao;
import org.example.library.dao.BookProvider;
import org.example.library.dao.RentalDao;
import org.example.library.dao.RentalLoader;
import org.example.library.model.Book;
import org.example.library.service.BookCheckerAvailable;
import org.example.library.service.RentalService;
import org.example.library.view.MainMenuView;
import org.example.library.view.View;

import java.util.Optional;


import java.util.List;

public class BookController {
    private BookProvider bookProvider;
    private RentalLoader rentalLoader;

    private BookCheckerAvailable bookCheckerAvailable;

    public BookController() {
        this.bookProvider = new BookDao();
        this.rentalLoader = new RentalDao();
        this.bookCheckerAvailable = new RentalService(new BookDao());
    }

    public BookController(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    //zwraca liste ksiazek
    public List<Book> showAvailableBooks() {
        List<Book> books = bookProvider.findAvailableBooks();
        if (books.isEmpty()) {
            System.out.println("There is no available books in library");
            return List.of();
        }
        return books;
    }

    //TODO Utworzyc instancje obiektu rental, ustawic obecne daty i date zwrotu, pobrac uzytkownika na podstawie apllication context i go ustawic w rental
    // pobrac ksiazke ponownie aby upewnic się czy nie zmieniła sie ilosc dostepnych ksiazek , zdjac jedna pozycje
    // w service sprawdzic czy sa dostepne jeszcze ksiazki
    public View rentBook(BookRentData bookRentData) {
        Optional<Book> book = bookCheckerAvailable.checkAndGetBook(bookRentData);
        if (book.isPresent()) {
            bookProvider.changeAmountOfBook(bookRentData.getIsbn());
            System.out.println("You rent this book: " + book.get().toMapString());
        } else {
            System.out.println("This books is currently unavailable!");
        }
        return new MainMenuView();
    }

    public void addNewRental() {

    }


}
