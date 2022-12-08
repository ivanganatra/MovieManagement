package ivan.cse.movie.service;

import ivan.cse.movie.message.request.CreateMovieForm;
import ivan.cse.movie.model.Movie;
import ivan.cse.movie.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieServices {
    List<Movie> getAllMovies();
    String addMovie(CreateMovieForm createMovieForm);
    List<Movie> getMoviesByCityId(String cityId);
    List<Movie> getMoviesByTheatreIdAndCityId(Long cityId, Long theatreId);
    List<Movie> getMoviesByTheatreIdAndCityIdAndDate(Long cityId, Long theatreId, LocalDate date);
}
