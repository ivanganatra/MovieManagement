package ivan.cse.movie.service;

import ivan.cse.movie.message.request.CreateSeatBookedForm;
import ivan.cse.movie.model.SeatBooked;

import java.util.List;

public interface SeatBookedServices {
    List<SeatBooked> getAllSeatBooked();
    String addSeatBooked(CreateSeatBookedForm createSeatBookedForm);
}
