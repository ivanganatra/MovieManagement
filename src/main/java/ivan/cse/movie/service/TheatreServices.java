package ivan.cse.movie.service;

import ivan.cse.movie.message.request.CreateTheatreForm;
import ivan.cse.movie.model.Theatre;

import java.util.List;

public interface TheatreServices {
    List<Theatre> getAllTheatres();
    String addTheatre(CreateTheatreForm createTheatreForm);
}
