package edu.wctc.rest;

import edu.wctc.entity.Movie;
import edu.wctc.exception.MovieNotFoundException;
import edu.wctc.exception.RestErrorResponse;
import edu.wctc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class MovieRestController {
    @Autowired
    private MovieService movieService;

    // mapping for GET /api/movies
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    // mapping for GET /api/movies/{id}
    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable int movieId) {
        Movie theMovie = movieService.getMovie(movieId);
        return theMovie;
    }

    // mapping for POST /api/movies
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie theMovie) {
        // Manually set ID to 0
        // Hibernate's saveOrUpdate() will insert if ID is null or 0
        // If client included an ID, we want to ignore it (set it to 0) because
        // POST always means create
        theMovie.setId(0);

        movieService.saveMovie(theMovie);

        // Return newly created donut to the client
        // It will have its ID assigned
        return theMovie;
    }

    // mapping for PUT /api/movies
    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie theMovie) {
        movieService.saveMovie(theMovie);

        // Return newly created movie to the client
        // It will have its ID assigned
        return theMovie;
    }

    //Mapping for DELETE /api/movies/{id}
    @DeleteMapping("/movies/{movieId}")
    public String deleteMovie(@PathVariable int movieId) {
        Movie doomedMovie = movieService.getMovie(movieId);

        // throw exception if the movie is not found
        if (doomedMovie == null) {
            throw new MovieNotFoundException("Movie ID is not found: " + movieId);
        }

        movieService.deleteMovie(movieId);

        return "Deleted movie ID: " + movieId;
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> handleException(MovieNotFoundException exception) {
        RestErrorResponse error = new RestErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<RestErrorResponse> handleException(Exception e) {
        RestErrorResponse error = new RestErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
