package org.example.library.dao;

import org.example.library.model.Rental;
import org.example.library.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RentalDao implements RentalBooksProvider {

    private static final String SEARCH_BY_ID_QUERY = "from Rental r where r.id=:id";

    @Override
    public List<Rental> findRentedAllBooksByUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Rental> query = session.createQuery(SEARCH_BY_ID_QUERY, Rental.class)
                .setParameter("id", id);
        List<Rental> allRented = query.getResultList();
        return allRented;
    }
}
