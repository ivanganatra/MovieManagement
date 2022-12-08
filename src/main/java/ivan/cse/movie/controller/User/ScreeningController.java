package ivan.cse.movie.controller.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateScreeningForm;
import ivan.cse.movie.message.response.ResponseMessage;
import ivan.cse.movie.model.Screening;
import ivan.cse.movie.service.ScreeningServices;
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
public class ScreeningController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private ScreeningServices screeningServices;

    @ApiOperation(value = "Get all Screenings",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_SCREENINGS, produces = "application/json")
    public ResponseEntity<List<Screening>>getAllScreenings(){
        return new ResponseEntity<List<Screening>>(screeningServices.getAllScreenings(),HttpStatus.OK);
    }
    @ApiOperation(value = "Get screening by theatre and city",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_SCREENINGS_BY_THEATRE_AND_CITY, produces = "application/json")
    public ResponseEntity<List<Screening>>getScreeningsByTheatreIdAndCityId(@PathVariable("cityId") Long cityId,@PathVariable("theatreId") Long theatreId){
        return new ResponseEntity<List<Screening>>(screeningServices.getScreeningsByTheatreIdAndCityId(cityId,theatreId),HttpStatus.OK);
    }

    @ApiOperation(value = "Get screening by theatre and city and date",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_SCREENINGS_BY_THEATRE_AND_CITY_AND_DATE, produces = "application/json")
    public ResponseEntity<List<Screening>>getScreeningsByTheatreIdAndCityIdAndDate(@PathVariable("cityId") Long cityId,
           @PathVariable("theatreId") Long theatreId,@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<List<Screening>>(screeningServices.getScreeningsByTheatreIdAndCityIdAndDate(cityId,theatreId,date),HttpStatus.OK);
    }

    @ApiOperation(value = "Get screening by movie and city",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_SCREENINGS_BY_MOVIE_AND_CITY, produces = "application/json")
    public ResponseEntity<List<Screening>>getScreeningsByMovieIdAndCityId(@PathVariable("cityId") Long cityId,@PathVariable("movieId") Long movieId){
        return new ResponseEntity<List<Screening>>(screeningServices.getScreeningsByMovieIdAndCityId(cityId,movieId),HttpStatus.OK);
    }

    @ApiOperation(value = "Get screening by movie and city and date",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_SCREENINGS_BY_MOVIE_AND_CITY_AND_DATE, produces = "application/json")
    public ResponseEntity<List<Screening>>getScreeningsByMovieIdAndCityIdAndDate(@PathVariable("cityId") Long cityId,
                                                                                   @PathVariable("movieId") Long movieId,@PathVariable("date")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<List<Screening>>(screeningServices.getScreeningsByMovieIdAndCityIdAndDate(cityId,movieId,date),HttpStatus.OK);
    }


    @ApiOperation(value = "Add screening",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_SCREENING, produces = "application/json")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody CreateScreeningForm createScreeningForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(screeningServices.addScreening(createScreeningForm)),
                HttpStatus.OK);
    }

}
