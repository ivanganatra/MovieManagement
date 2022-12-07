package ivan.cse.movie.controller.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateMovieForm;
import ivan.cse.movie.message.response.ResponseMessage;
import ivan.cse.movie.model.Movie;
import ivan.cse.movie.service.MovieServices;
import ivan.cse.movie.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/user")
@Api(value = "User")
public class MovieController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private MovieServices theatreServices;

    @ApiOperation(value = "Get all Movies",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_MOVIES, produces = "application/json")
    public ResponseEntity<List<Movie>>getAllMovies(){
        return new ResponseEntity<List<Movie>>(theatreServices.getAllMovies(),HttpStatus.OK);
    }
    @ApiOperation(value = "Get movies by city",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_MOVIES_BY_CITY, produces = "application/json")
    public ResponseEntity<List<Movie>>getMoviesByCityId(@PathVariable("cityId") String cityId){
        return new ResponseEntity<List<Movie>>(theatreServices.getMoviesByCityId(cityId),HttpStatus.OK);
    }


    @ApiOperation(value = "Add movies",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_MOVIE, produces = "application/json")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody CreateMovieForm createMovieForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(theatreServices.addMovie(createMovieForm)),
                HttpStatus.OK);
    }

}
