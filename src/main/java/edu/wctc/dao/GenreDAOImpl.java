package edu.wctc.dao;

import edu.wctc.entity.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Genre> getGenres() {
        Session session = sessionFactory.getCurrentSession();

        List<Genre> list = session.createQuery("from Genre", Genre.class).getResultList();

        return list;
    }

    @Override
    public Genre getGenre(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Genre.class, id);
    }
}
