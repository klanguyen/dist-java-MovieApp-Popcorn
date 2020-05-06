package edu.wctc.service;

import edu.wctc.entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getGenres();

    Genre getGenre(int id);
}
