package ivan.cse.movie.controller.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ivan.cse.movie.constants.RestAPI;
import ivan.cse.movie.message.request.CreateBookingForm;
import ivan.cse.movie.message.response.ResponseMessage;
import ivan.cse.movie.model.Booking;
import ivan.cse.movie.service.BookingServices;
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
public class BookingController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private BookingServices bookingServices;

    @ApiOperation(value = "Get all Bookings",httpMethod = "GET")
    @GetMapping(path = RestAPI.GET_BOOKINGS, produces = "application/json")
    public ResponseEntity<List<Booking>>getAllBookings() {
        return new ResponseEntity<List<Booking>>(bookingServices.getAllBookings(), HttpStatus.OK);
    }


    @ApiOperation(value = "Add bookings",httpMethod = "POST")
    @PostMapping(path = RestAPI.ADD_BOOKING, produces = "application/json")
    public ResponseEntity<ResponseMessage> createBooking(@RequestBody CreateBookingForm createBookingForm){
        return new ResponseEntity<ResponseMessage>(new ResponseMessage(bookingServices.addBooking(createBookingForm)),
                HttpStatus.OK);
    }

}
