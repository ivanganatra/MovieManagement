package ivan.cse.movie.service;

import ivan.cse.movie.message.request.CreateSeatForm;
import ivan.cse.movie.model.Seat;

import java.util.List;

public interface SeatServices {
    List<Seat> getAllSeats();
    String addSeat(CreateSeatForm createSeatForm);
    List<Seat> getSeatsByScreening(Long screeningId);
}
