package org.example.library;

import org.example.library.view.BooksView;
import org.example.library.view.LoginView;
import org.example.library.view.View;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        View view = new LoginView(Optional.empty());
//        view.display();
        View view = new BooksView();
        view.display();
    }
}
