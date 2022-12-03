package ivan.cse.movie.controller.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateCityForm;
import ivan.cse.movie.message.request.CreateUserForm;
import ivan.cse.movie.model.City;
import ivan.cse.movie.model.User;
import ivan.cse.movie.service.CityServices;
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
public class CityController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private CityServices cityServices;

    @ApiOperation(value = "Get all Cities",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_CITIES, produces = "application/json")
    public ResponseEntity<List<City>>getAllCities(){
        return new ResponseEntity<List<City>>(cityServices.getAllCities(),HttpStatus.OK);
    }

    @ApiOperation(value = "Add cities",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_CITY, produces = "application/json")
    public ResponseEntity<ResponseMessage> createCity(@RequestBody CreateCityForm createCityForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(cityServices.addCity(createCityForm)),
                HttpStatus.OK);
    }

}
