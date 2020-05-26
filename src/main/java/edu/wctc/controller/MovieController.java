package edu.wctc.controller;

import edu.wctc.entity.Movie;
import edu.wctc.service.GenreService;
import edu.wctc.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private GenreService genreService;

    @GetMapping("/list")
    public String listMovies(Model theModel) {
        List<Movie> theList = movieService.getMovies();

        theModel.addAttribute("movies", theList);

        return "/list-movies";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm,
                         Model theModel) {
        List<Movie> matchingMovies = movieService.getMoviesByName(theSearchTerm);

        theModel.addAttribute("movies", matchingMovies);

        return "/list-movies";
    }

    @GetMapping("/admin/delete")
    public String deleteMovie(@RequestParam("movieId") int theId) {
        movieService.deleteMovie(theId);

        return "redirect:/movie/list";
    }

    @RequestMapping("/user/showUpdateMovieForm")
    public String showUpdateMovieForm(@RequestParam("movieId") int theId,
                                      Model theModel) {
        Movie existingMovie = movieService.getMovie(theId);

        theModel.addAttribute("aMovie", existingMovie);
        theModel.addAttribute("genres", genreService.getGenres());

        return "/movie-form";
    }

    @RequestMapping("/user/showAddMovieForm")
    public String showAddMovieForm(Model theModel) {
        Movie newMovie = new Movie();

        theModel.addAttribute("aMovie", newMovie);
        theModel.addAttribute("genres", genreService.getGenres());

        return "/movie-form";
    }

    @PostMapping("/user/save")
    public String saveMovie(@Valid @ModelAttribute("aMovie") Movie theMovie,
                            BindingResult bindingResult,
                            Model theModel) {
        // check if there is any validation errors
        if (bindingResult.hasErrors()) {
            //Display the errors in the console
            System.err.println(bindingResult);

            //Put the list of movie genres back in the new model
            theModel.addAttribute("genres", genreService.getGenres());

            //Send back to form with error messages
            return "/movie-form";
        }

        // update the movie
        movieService.saveMovie(theMovie);

        // redirect to the movie list
        return "redirect:/movie/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        // trim whitespace from all string form parameters read by this controller
        // if the entire string is whitespace, trim it to null
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, ste);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        e.printStackTrace();
    }
}
