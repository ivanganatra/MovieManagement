package ivan.cse.movie.service;

import ivan.cse.movie.message.request.CreateMovieForm;
import ivan.cse.movie.model.Movie;

import java.util.List;

public interface MovieServices {
    List<Movie> getAllMovies();
    String addMovie(CreateMovieForm createMovieForm);
    List<Movie> getMoviesByCityId(String cityId);
}
