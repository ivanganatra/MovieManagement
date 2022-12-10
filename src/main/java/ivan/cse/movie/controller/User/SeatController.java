package ivan.cse.movie.controller.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateSeatForm;
import ivan.cse.movie.message.response.ResponseMessage;
import ivan.cse.movie.model.Seat;
import ivan.cse.movie.service.SeatServices;
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
public class SeatController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private SeatServices seatServices;

    @ApiOperation(value = "Get all Seats",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_SEATS, produces = "application/json")
    public ResponseEntity<List<Seat>>getAllSeats(){
        return new ResponseEntity<List<Seat>>(seatServices.getAllSeats(),HttpStatus.OK);
    }
    @ApiOperation(value = "Get seats by screening",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_SEATS_BY_SCREENING, produces = "application/json")
    public ResponseEntity<List<Seat>>getSeatsByScreening(@PathVariable("screeningId") Long screeningId){
        return new ResponseEntity<List<Seat>>(seatServices.getSeatsByScreening(screeningId),HttpStatus.OK);
    }

    @ApiOperation(value = "Add seats",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_SEAT, produces = "application/json")
    public ResponseEntity<ResponseMessage> createUser(@RequestBody CreateSeatForm createSeatForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(seatServices.addSeat(createSeatForm)),
                HttpStatus.OK);
    }

}
