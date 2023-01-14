package org.example.library.view;

import lombok.AllArgsConstructor;
import org.example.library.api.UserLoginData;
import org.example.library.controller.LoginController;

import java.util.Scanner;

public class LoginView implements View {

    private final Scanner scanner;
    private final LoginController loginController;

    public LoginView(Scanner scanner,
                     LoginController loginController) {
        this.scanner = scanner;
        this.loginController = loginController;
    }

    public void display() {
        System.out.println("podaj login");
        String login = scanner.nextLine();
        System.out.println("podaj haslo");
        String password = scanner.nextLine();
        loginController.login(new UserLoginData(login, password));
    }

}
