package ivan.cse.movie.controller.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateAuditoriumForm;
import ivan.cse.movie.message.response.ResponseMessage;
import ivan.cse.movie.model.Auditorium;
import ivan.cse.movie.service.AuditoriumServices;
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
public class AuditoriumController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private AuditoriumServices auditoriumServices;

    @ApiOperation(value = "Get all Auditoriums",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_AUDITORIUMS, produces = "application/json")
    public ResponseEntity<List<Auditorium>>getAllAuditoriums(){
        return new ResponseEntity<List<Auditorium>>(auditoriumServices.getAllAuditoriums(),HttpStatus.OK);
    }
    @ApiOperation(value = "Get auditoriums by theatre",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_AUDITORIUMS_BY_THEATRE, produces = "application/json")
    public ResponseEntity<List<Auditorium>>getAuditoriumsByTheatre(@PathVariable("theatreId") Long theatreId){
        return new ResponseEntity<List<Auditorium>>(auditoriumServices.getAuditoriumsByTheatreId(theatreId),HttpStatus.OK);
    }

    @ApiOperation(value = "Get auditoriums by city",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_AUDITORIUMS_BY_CITY, produces = "application/json")
    public ResponseEntity<List<Auditorium>>getAuditoriumsByCity(@PathVariable("cityId") Long cityId){
        return new ResponseEntity<List<Auditorium>>(auditoriumServices.getAuditoriumsByCityId(cityId),HttpStatus.OK);
    }


    @ApiOperation(value = "Add auditoriums",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_AUDITORIUM, produces = "application/json")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody CreateAuditoriumForm createAuditoriumForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(auditoriumServices.addAuditorium(createAuditoriumForm)),
                HttpStatus.OK);
    }

}
