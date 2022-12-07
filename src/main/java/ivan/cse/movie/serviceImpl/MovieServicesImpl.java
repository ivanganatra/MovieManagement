package ivan.cse.movie.serviceImpl;

import ivan.cse.movie.message.request.CreateMovieForm;
import ivan.cse.movie.model.Movie;
import ivan.cse.movie.repo.CityRepository;
import ivan.cse.movie.repo.MovieRepository;
import ivan.cse.movie.service.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServicesImpl implements MovieServices {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CityRepository cityRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> getMoviesByCityId(String cityId){

        //Not Yet Tested
        return movieRepository.findAll();
//        return movieRepository.findByCityId(cityId);
    }
    public String addMovie(CreateMovieForm createMovieForm) throws DataIntegrityViolationException{
        try {
            Movie movie = new Movie();
            movie.setTitle(createMovieForm.getTitle());
            movie.setGenre(createMovieForm.getGenre());
            movie.setDuration(createMovieForm.getDuration());
            movieRepository.save(movie);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Movie already Exists.");
        }
        return "Movie added successfully";
    }
}

