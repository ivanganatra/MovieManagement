package ivan.cse.movie.message.request;

import javax.validation.constraints.NotBlank;


public class CreateSeatForm {

    @NotBlank
    public String seatNumber;
    
    @NotBlank
    public String seatType;

    @NotBlank
    public String seatStatus;

    @NotBlank
    public Long auditoriumId;

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Long getAuditoriumId() {
        return auditoriumId;
    }

    public void setAuditoriumId(Long auditoriumId) {
        this.auditoriumId = auditoriumId;
    }
}
