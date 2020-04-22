package edu.wctc.hibernate;

import edu.wctc.entity.FeaturedCrew;
import edu.wctc.entity.Genre;
import edu.wctc.entity.Movie;
import edu.wctc.entity.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp(){
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(FeaturedCrew.class)
                .addAnnotatedClass(Genre.class)
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Position.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        HibernateApp hibernateApp = new HibernateApp();

        try {
            hibernateApp.createFeaturedCrewAndPosition();
        } finally {
            hibernateApp.close();
        }
    }

    // create, read, update, delete Featured Crew
    private int createFeaturedCrew(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FeaturedCrew newFeaturedCrew = new FeaturedCrew("Mike Flanagan");

        session.save(newFeaturedCrew);

        session.getTransaction().commit();

        return newFeaturedCrew.getFeaturedCrewId();
    }

    private void readFeaturedCrew(int featuredCrewId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FeaturedCrew aFeaturedCrew = session.get(FeaturedCrew.class, featuredCrewId);

        if (aFeaturedCrew == null){
            System.out.println("No featured crew found for ID" + featuredCrewId);
        } else {
            System.out.println(aFeaturedCrew);
        }

        session.getTransaction().commit();
    }

    private void printFeaturedCrewList(List<FeaturedCrew> list) {
        if(list.isEmpty()) {
            System.out.println("No featured crews in list");
        } else {
            for (FeaturedCrew fc : list) {
                System.out.println(fc);
            }
        }
    }

    private void listAllFeatureCrews(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<FeaturedCrew> list = session.createQuery("from FeaturedCrew order by name").getResultList();

        printFeaturedCrewList(list);

        session.getTransaction().commit();
    }

    private void updateFeaturedCrew(int featuredCrewId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FeaturedCrew aFeaturedCrew = session.get(FeaturedCrew.class, featuredCrewId);

        if (aFeaturedCrew != null)
            aFeaturedCrew.setName(aFeaturedCrew.getName() + " UPDATED");

        session.getTransaction().commit();
    }

    private void deleteFeaturedCrew(int featuredCrewId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FeaturedCrew doomedFeaturedCrew = session.get(FeaturedCrew.class, featuredCrewId);

        if (doomedFeaturedCrew != null)
            session.delete(doomedFeaturedCrew);

        session.getTransaction().commit();
    }

    // create, read, update, delete Genre
    private int createGenre(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Genre newGenre = new Genre("Documentary");

        session.save(newGenre);

        session.getTransaction().commit();

        return newGenre.getGenreId();
    }

    private void readGenre(int genreId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Genre aGenre = session.get(Genre.class, genreId);

        if (aGenre == null){
            System.out.println("No genre found for ID" + genreId);
        } else {
            System.out.println(aGenre);
        }

        session.getTransaction().commit();
    }

    private void printGenreList(List<Genre> list) {
        if(list.isEmpty()) {
            System.out.println("No genre in list");
        } else {
            for (Genre g : list) {
                System.out.println(g);
            }
        }
    }

    private void listAllGenres(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Genre> list = session.createQuery("from Genre order by description").getResultList();

        printGenreList(list);

        session.getTransaction().commit();
    }

    private void updateGenre(int genreId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Genre aGenre = session.get(Genre.class, genreId);

        if (aGenre != null)
            aGenre.setDescription(aGenre.getDescription() + " UPDATED");

        session.getTransaction().commit();
    }

    private void deleteGenre(int genreId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Genre doomedGenre = session.get(Genre.class, genreId);

        if (doomedGenre != null)
            session.delete(doomedGenre);

        session.getTransaction().commit();
    }

    // create, read, update, delete Movie
    private int createMovie(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Movie newMovie = new Movie("Frozen", "A modern Disney cartoon", 2017);

        session.save(newMovie);

        session.getTransaction().commit();

        return newMovie.getMovieId();
    }

    private void readMovie(int movieId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Movie aMovie = session.get(Movie.class, movieId);

        if (aMovie == null){
            System.out.println("No movie found for ID" + movieId);
        } else {
            System.out.println(aMovie);
        }

        session.getTransaction().commit();
    }

    private void printMovieList(List<Movie> list) {
        if(list.isEmpty()) {
            System.out.println("No movie in list");
        } else {
            for (Movie m : list) {
                System.out.println(m);
            }
        }
    }

    private void listAllMovies(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Movie> list = session.createQuery("from Movie order by movie_nm").getResultList();

        printMovieList(list);

        session.getTransaction().commit();
    }

    private void updateMovie(int movieId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Movie aMovie = session.get(Movie.class, movieId);

        if (aMovie != null)
            aMovie.setName(aMovie.getName() + " UPDATED");

        session.getTransaction().commit();
    }

    private void deleteMovie(int movieId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Movie doomedMovie = session.get(Movie.class, movieId);

        if (doomedMovie != null)
            session.delete(doomedMovie);

        session.getTransaction().commit();
    }

    // create, read, update, delete Position
    private int createPosition(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Position newPosition = new Position("Producer");

        session.save(newPosition);

        session.getTransaction().commit();

        return newPosition.getPositionId();
    }

    private void readPosition(int positionId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Position aPosition = session.get(Position.class, positionId);

        if (aPosition == null){
            System.out.println("No position found for ID" + positionId);
        } else {
            System.out.println(aPosition);
        }

        session.getTransaction().commit();
    }

    private void printPositionList(List<Position> list) {
        if(list.isEmpty()) {
            System.out.println("No position in list");
        } else {
            for (Position p : list) {
                System.out.println(p);
            }
        }
    }

    private void listAllPositions(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        List<Position> list = session.createQuery("from Position order by description").getResultList();

        printPositionList(list);

        session.getTransaction().commit();
    }

    private void updatePosition(int positionId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Position aPosition = session.get(Position.class, positionId);

        if (aPosition != null)
            aPosition.setDescription(aPosition.getDescription() + " UPDATED");

        session.getTransaction().commit();
    }

    private void deletePosition(int positionId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        Position doomedPosition = session.get(Position.class, positionId);

        if (doomedPosition != null)
            session.delete(doomedPosition);

        session.getTransaction().commit();
    }

    private void createFeaturedCrewAndPosition(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        // Do stuff
        FeaturedCrew featuredCrew = new FeaturedCrew("Jeff Draheim");
        session.save(featuredCrew);

        Position position = new Position("Film Editor");
        featuredCrew.add(position);
        session.save(position);

        session.getTransaction().commit();
    }

    private void close() {
        factory.close();
    }
}
