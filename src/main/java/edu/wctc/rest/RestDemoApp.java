package edu.wctc.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.wctc.entity.Movie;

import java.io.File;
import java.io.IOException;

public class RestDemoApp {
    private ObjectMapper mapper;

    public RestDemoApp() {
        // Create Jackson JSON mapper
        ObjectMapper mapper = new ObjectMapper();

        // Enable pretty-print output
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Support for Java 8 temporal classes like LocaleDate
        mapper.registerModule(new JavaTimeModule());
    }

    public static void main(String[] args) throws IOException {
        new RestDemoApp().readWriteMovie();
    }

    public void readWriteMovie() throws IOException {
        File input = new File("rest-data/movie-in.json");

        Movie aMovie = mapper.readValue(input, Movie.class);

        System.out.println(aMovie);

        File output = new File("rest-data/movie-out.json");

        mapper.writeValue(output, aMovie);
    }
}
