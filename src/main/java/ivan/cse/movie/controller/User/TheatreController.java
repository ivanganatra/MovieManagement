package ivan.cse.movie.controller.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateTheatreForm;
import ivan.cse.movie.message.request.CreateUserForm;
import ivan.cse.movie.model.Movie;
import ivan.cse.movie.model.Theatre;
import ivan.cse.movie.model.Theatre;
import ivan.cse.movie.model.User;
import ivan.cse.movie.service.TheatreServices;
import ivan.cse.movie.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ivan.cse.movie.message.response.ResponseMessage;

import javax.xml.ws.Response;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/user")
@Api(value = "User")
public class TheatreController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private TheatreServices theatreServices;

    @ApiOperation(value = "Get all Theatres",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_THEATRES, produces = "application/json")
    public ResponseEntity<List<Theatre>>getAllTheatres(){
        return new ResponseEntity<List<Theatre>>(theatreServices.getAllTheatres(),HttpStatus.OK);
    }
    @ApiOperation(value = "Get theatres by city",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_THEATRES_BY_CITY, produces = "application/json")
    public ResponseEntity<List<Theatre>>getTheatresByCityId(@PathVariable("cityId") Long cityId){
        return new ResponseEntity<List<Theatre>>(theatreServices.getTheatresByCityId(cityId),HttpStatus.OK);
    }

    @ApiOperation(value = "Get theatre by movie and city",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_THEATRES_BY_MOVIE_AND_CITY, produces = "application/json")
    public ResponseEntity<List<Theatre>>getTheatresByMovieIdAndCityId(@PathVariable("cityId") Long cityId,@PathVariable("movieId") Long movieId){
        return new ResponseEntity<List<Theatre>>(theatreServices.getTheatresByMovieIdAndCityId(cityId,movieId),HttpStatus.OK);
    }

    @ApiOperation(value = "Get theatre by movie and city and date",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_THEATRES_BY_MOVIE_AND_CITY_AND_DATE, produces = "application/json")
    public ResponseEntity<List<Theatre>>getTheatresByMovieIdAndCityIdAndDate(@PathVariable("cityId") Long cityId,
                                                                                 @PathVariable("movieId") Long movieId,@PathVariable("date")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<List<Theatre>>(theatreServices.getTheatresByMovieIdAndCityIdAndDate(cityId,movieId,date),HttpStatus.OK);
    }

    @ApiOperation(value = "Add theatres",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_THEATRE, produces = "application/json")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody CreateTheatreForm createTheatreForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(theatreServices.addTheatre(createTheatreForm)),
                HttpStatus.OK);
    }

}
