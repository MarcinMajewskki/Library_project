package org.example.library.dao;

import org.example.library.model.Book;
import org.example.library.model.Rental;
import org.example.library.model.User;
import org.example.library.utils.HibernateUtil;
import org.hibernate.Session;

import java.time.LocalDate;


public class RentalDao implements RentalLoader {
    @Override
    public void addBookToRentalList(Book book, User user) {
        Rental rental = new Rental();
        rental.setBook(book);
        rental.setUser(user);
        rental.setRentDate(LocalDate.now());
        rental.setDueDate(rental.getRentDate().plusMonths(1));
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.persist(rental);
        session.close();
    }
}
