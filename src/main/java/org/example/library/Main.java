package org.example.library;

import org.example.library.model.User;
import org.example.library.utils.HibernateUtil;
import org.example.library.view.LoginView;
import org.example.library.view.View;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
        View view = new LoginView(Optional.empty());
        view.display();
    }
}
