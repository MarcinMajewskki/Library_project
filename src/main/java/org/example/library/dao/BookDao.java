package org.example.library.dao;

import org.example.library.model.Book;
import org.example.library.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;


public class BookDao implements BookProvider {
    private static final String FIND_AVAILABLE_BOOKS = "from Book b where b.amountAvailable > 0";
    private static final String CHECK_IF_BOOK_IS_AVAILABLE = "from Book b where b.amountAvailable > 0 and b.isbn=:isbn";
    private static final String UPDATE_NUMBER_OF_AVAILABLE_BOOKS = "from Book b where b.isbn=:isbn";


    @Override
    public List<Book> findAvailableBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Book> query = session.createQuery(FIND_AVAILABLE_BOOKS, Book.class);
        List<Book> books = query.getResultList();
        session.close();
        return books;
    }

    @Override
    public Optional<Book> checkIfBookIsAvailable(Integer isbn) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Book> query = session.createQuery(CHECK_IF_BOOK_IS_AVAILABLE, Book.class).
                setParameter("isbn", isbn);
        Optional<Book> book = query.getResultList().stream().findFirst();
        session.close();
        return book;
    }

    @Override
    public void changeAmountOfBook(Integer isbn) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Book> query = session.createQuery(UPDATE_NUMBER_OF_AVAILABLE_BOOKS, Book.class).
                setParameter("isbn", isbn);
        Book book = query.getSingleResult();
        book.setAmountAvailable(book.getAmountAvailable() - 1);
        session.update(book);
        session.close();
    }
//sessionupdate - aktualizacje
    //persist - dodawanie danych w bazie
    //TODO Utworzyc instancje obiektu rental, ustawic obecne daty i date zwrotu, pobrac uzytkownika na podstawie apllication context i go ustawic w rental
    // pobrac ksiazke ponownie aby upewnic się czy nie zmieniła sie ilosc dostepnych ksiazek , zdjac jedna pozycje
    // w service sprawdzic czy sa dostepne jeszcze ksiazki

}
