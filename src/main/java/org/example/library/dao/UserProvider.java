package org.example.library.dao;

import org.example.library.model.User;

public interface UserProvider {

    User findUserById(int id);

}
