package org.example.library;

import org.example.library.model.User;
import org.example.library.utils.HibernateUtil;
import org.example.library.view.LoginView;
import org.example.library.view.View;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession().close();
        View view = new LoginView(Optional.empty());
        view.display();
    }
}
