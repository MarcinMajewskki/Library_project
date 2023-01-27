package org.example.library.view;

import org.example.library.api.BookRentData;
import org.example.library.controller.BookController;
import org.example.library.model.Book;
import org.example.library.utils.DisplayMapper;

import static org.apache.commons.lang3.math.NumberUtils.isParsable;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class BooksView implements View {
    private final BookController bookController;
    private final Scanner scanner;

    public BooksView() {
        this.scanner = new Scanner(System.in);
        this.bookController = new BookController();
    }

    //TODO na koncu wyswietlic Main menu

    @Override
    public void display() {
        List<Book> books = bookController.showAvailableBooks();
        Map<Integer, Book> booksMaps = DisplayMapper.convertToMap(books);
        booksMaps.forEach((integer, book) -> System.out.println(integer + ". " + book.toMapString()));
        Book book = booksMaps.get(parseInput());
//        System.out.println(book);
        BookRentData bookRentData = new BookRentData(book.getIsbn());
        bookController.rentBook(bookRentData).display();
    }

    private Integer parseInput() {
        System.out.println("Input book number to rent:");
        String selectedBookNumber = scanner.nextLine();
        if (isParsable(selectedBookNumber)) {
            return Integer.parseInt(selectedBookNumber);
        } else {
            return parseInput();
        }
    }


}
