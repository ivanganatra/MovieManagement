package ivan.cse.movie.message.request;

import javax.validation.constraints.NotBlank;


public class CreateAuditoriumForm {

    @NotBlank
    public String name;
    
    @NotBlank
    public Long seatCount;
    
    @NotBlank
    public Long theatreId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Long seatCount) {
        this.seatCount = seatCount;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }
}
