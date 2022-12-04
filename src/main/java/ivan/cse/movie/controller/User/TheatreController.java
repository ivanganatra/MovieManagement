package ivan.cse.movie.controller.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateTheatreForm;
import ivan.cse.movie.message.request.CreateUserForm;
import ivan.cse.movie.model.Theatre;
import ivan.cse.movie.model.User;
import ivan.cse.movie.service.TheatreServices;
import ivan.cse.movie.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ivan.cse.movie.message.response.ResponseMessage;

import javax.xml.ws.Response;
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
    @ApiOperation(value = "Get theatres by city name",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_THEATRES_BY_CITY_NAME, produces = "application/json")
    public ResponseEntity<List<Theatre>>getTheatresByCityName(@PathVariable("cityName") String cityName){
        return new ResponseEntity<List<Theatre>>(theatreServices.getTheatresByCityName(cityName),HttpStatus.OK);
    }


    @ApiOperation(value = "Add theatres",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_THEATRE, produces = "application/json")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody CreateTheatreForm createTheatreForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(theatreServices.addTheatre(createTheatreForm)),
                HttpStatus.OK);
    }

}
