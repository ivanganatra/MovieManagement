package ivan.cse.movie.controller.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateSeatBookedForm;
import ivan.cse.movie.message.response.ResponseMessage;
import ivan.cse.movie.model.SeatBooked;
import ivan.cse.movie.service.SeatBookedServices;
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
public class SeatBookedController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private SeatBookedServices seatBookedServices;

    @ApiOperation(value = "Get all SeatBooked",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_SEAT_BOOKED, produces = "application/json")
    public ResponseEntity<List<SeatBooked>>getAllSeatBooked(){
        return new ResponseEntity<List<SeatBooked>>(seatBookedServices.getAllSeatBooked(),HttpStatus.OK);
    }

    @ApiOperation(value = "Add seat booked",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_SEAT_BOOKED, produces = "application/json")
    public ResponseEntity<ResponseMessage> addSeatBooked(@RequestBody CreateSeatBookedForm createSeatBookedForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(seatBookedServices.addSeatBooked(createSeatBookedForm)),
                HttpStatus.OK);
    }

}
