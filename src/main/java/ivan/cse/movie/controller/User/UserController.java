package ivan.cse.movie.controller.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateUserForm;
import ivan.cse.movie.model.User;
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
public class UserController {

    @Autowired
    private UserServices userServices;

    @ApiOperation(value = "Get all Users",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_USER, produces = "application/json")
    public ResponseEntity<List<User>>getAllUsers(){
        return new ResponseEntity<List<User>>(userServices.getAllUsers(),HttpStatus.OK);
    }

    @ApiOperation(value = "Create User",httpMethod = "POST")
    @PostMapping(path = RestAPI.REGISTER_USER, produces = "application/json")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody CreateUserForm createUserForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(userServices.createUser(createUserForm)),
                HttpStatus.OK);
    }

}
