package edu.wctc.exception;

/**
 * A runtime (unchecked) exception. This class doesn't do
 * anything special, but it acts like a "marker" so our
 * application can detect when a movie isn't found.
 */
public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String message) {
        super(message);
    }
}
