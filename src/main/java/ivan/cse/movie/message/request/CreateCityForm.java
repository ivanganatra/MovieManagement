package ivan.cse.movie.message.request;

import javax.validation.constraints.NotBlank;


public class CreateCityForm {

    @NotBlank
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
