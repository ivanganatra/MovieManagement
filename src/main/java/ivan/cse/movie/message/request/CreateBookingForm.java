package ivan.cse.movie.message.request;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;


public class CreateBookingForm {

    @NotBlank
    public Long bookingId;
    
    @NotBlank
    public LocalTime bookingTime;

    public boolean isActive;

    public boolean isBooked;

    @NotBlank
    public Long ScreeningId;

    @NotBlank
    public Long userId;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Long getScreeningId() {
        return ScreeningId;
    }

    public void setScreeningId(Long screeningId) {
        ScreeningId = screeningId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
