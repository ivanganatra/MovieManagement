package ivan.cse.movie.message.request;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;


public class CreateSeatBookedForm {

    @NotBlank
    public Long id;

    @NotBlank
    public Long bookingId;

    @NotBlank
    public ArrayList<Long> seats;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public ArrayList<Long> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Long> seats) {
        this.seats = seats;
    }
}
