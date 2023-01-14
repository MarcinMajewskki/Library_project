package org.example.library.controller;

import org.example.library.api.UserLoginData;
import org.example.library.dao.UserProvider;
import org.example.library.model.User;
import org.example.library.service.UserLoginChecker;
import org.example.library.view.LoginView;
import org.example.library.view.View;

import java.util.Optional;

public class LoginController {

    private UserLoginChecker userLoginChecker;

    public View login(UserLoginData userLoginData) {
        Optional<User> user = userLoginChecker.checkAndGet(userLoginData);
        if (user.isPresent()) {
            return MainMenuView();
        }
        return new LoginView();
    }

}
