package ivan.cse.movie.message.request;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;


public class CreateScreeningForm {

    @NotBlank
    public LocalDate date;

    @NotBlank
    public LocalTime startTime;

    @NotBlank
    public LocalTime endTime;

    @NotBlank
    public Boolean isFull;

    @NotBlank
    public Double price;

    @NotBlank
    public Long auditoriumId;

    @NotBlank
    public Long movieId;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsFull() {
        return isFull;
    }

    public void setIsFull(Boolean full) {
        isFull = full;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(Long auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
