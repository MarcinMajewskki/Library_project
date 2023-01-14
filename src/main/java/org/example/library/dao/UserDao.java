package org.example.library.dao;

import org.example.library.model.User;

import java.util.Optional;

public class UserDao implements UserProvider {

    @Override
    public Optional<User> findUserByLogin(String login) {
        return Optional.empty();
    }

}
