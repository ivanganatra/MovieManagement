package ivan.cse.movie.service;

import ivan.cse.movie.message.request.CreateAuditoriumForm;
import ivan.cse.movie.model.Auditorium;

import java.util.List;

public interface AuditoriumServices {
    List<Auditorium> getAllAuditoriums();
    String addAuditorium(CreateAuditoriumForm createAuditoriumForm);
    List<Auditorium> getAuditoriumsByTheatreId(String theatreId);
    List<Auditorium> getAuditoriumsByCityId(String cityId);
}
