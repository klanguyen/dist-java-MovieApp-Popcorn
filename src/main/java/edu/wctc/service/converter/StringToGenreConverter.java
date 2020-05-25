package edu.wctc.service.converter;

import edu.wctc.entity.Genre;
import edu.wctc.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToGenreConverter implements Converter<String, Genre> {
    @Autowired
    private GenreService genreService;

    @Override
    public Genre convert(String source) {
        int genreID = Integer.parseInt(source);
        Genre aGenre = genreService.getGenre(genreID);

        return aGenre;
    }
}
