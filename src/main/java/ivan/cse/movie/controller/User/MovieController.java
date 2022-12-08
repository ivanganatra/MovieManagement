package ivan.cse.movie.controller.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateMovieForm;
import ivan.cse.movie.message.response.ResponseMessage;
import ivan.cse.movie.model.Movie;
import ivan.cse.movie.model.Screening;
import ivan.cse.movie.service.MovieServices;
import ivan.cse.movie.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/user")
@Api(value = "User")
public class MovieController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private MovieServices movieServices;


    @ApiOperation(value = "Get all Movies",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_MOVIES, produces = "application/json")
    public ResponseEntity<List<Movie>>getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieServices.getAllMovies(),HttpStatus.OK);
    }
    @ApiOperation(value = "Get movies by city",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_MOVIES_BY_CITY, produces = "application/json")
    public ResponseEntity<List<Movie>>getMoviesByCityId(@PathVariable("cityId") String cityId){
        return new ResponseEntity<List<Movie>>(movieServices.getMoviesByCityId(cityId),HttpStatus.OK);
    }

    @ApiOperation(value = "Get movie by theatre and city",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_MOVIES_BY_THEATRE_AND_CITY, produces = "application/json")
    public ResponseEntity<List<Movie>>getMoviesByTheatreIdAndCityId(@PathVariable("cityId") Long cityId, @PathVariable("theatreId") Long theatreId){
        return new ResponseEntity<List<Movie>>(movieServices.getMoviesByTheatreIdAndCityId(cityId,theatreId),HttpStatus.OK);
    }

    @ApiOperation(value = "Get movie by theatre and city and date",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_MOVIES_BY_THEATRE_AND_CITY_AND_DATE, produces = "application/json")
    public ResponseEntity<List<Movie>>getMoviesByTheatreIdAndCityIdAndDate(@PathVariable("cityId") Long cityId,
                                                                           @PathVariable("theatreId") Long theatreId,@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<List<Movie>>(movieServices.getMoviesByTheatreIdAndCityIdAndDate(cityId,theatreId,date),HttpStatus.OK);
    }


    @ApiOperation(value = "Add movies",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_MOVIE, produces = "application/json")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody CreateMovieForm createMovieForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(movieServices.addMovie(createMovieForm)),
                HttpStatus.OK);
    }

}
