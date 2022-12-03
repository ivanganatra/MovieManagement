package ivan.cse.movie.message.request;

import javax.validation.constraints.NotBlank;


public class CreateTheatreForm {

    @NotBlank
    public String name;
    @NotBlank
    public Long cityId;


    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
