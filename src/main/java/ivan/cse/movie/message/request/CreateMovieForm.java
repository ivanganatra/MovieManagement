package ivan.cse.movie.message.request;

import javax.validation.constraints.NotBlank;


public class CreateMovieForm {
    
    @NotBlank
    public String genre;

    @NotBlank
    public String title;

    @NotBlank
    public Long duration;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration=duration;
    }

}
