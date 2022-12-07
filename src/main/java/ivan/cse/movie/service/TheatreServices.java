package ivan.cse.movie.service;

import ivan.cse.movie.message.request.CreateTheatreForm;
import ivan.cse.movie.model.Theatre;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TheatreServices {
    List<Theatre> getAllTheatres();
    String addTheatre(CreateTheatreForm createTheatreForm);
    List<Theatre> getTheatresByCityId(String cityId);
}
