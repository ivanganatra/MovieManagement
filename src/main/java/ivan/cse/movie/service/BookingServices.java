package ivan.cse.movie.service;

import ivan.cse.movie.message.request.CreateBookingForm;
import ivan.cse.movie.model.Booking;

import java.util.List;

public interface BookingServices {
    List<Booking> getAllBookings();
    String addBooking(CreateBookingForm createBookingForm);
}
