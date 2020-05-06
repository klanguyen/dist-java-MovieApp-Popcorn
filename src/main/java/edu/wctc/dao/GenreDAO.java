package edu.wctc.dao;

import edu.wctc.entity.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> getGenres();

    Genre getGenre(int id);
}
