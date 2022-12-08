package ivan.cse.movie.service;

import ivan.cse.movie.message.request.CreateScreeningForm;
import ivan.cse.movie.model.Screening;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningServices {
    List<Screening> getAllScreenings();
    String addScreening(CreateScreeningForm createScreeningForm);
    List<Screening> getScreeningsByTheatreIdAndCityId(Long cityId,Long theatreId);
    List<Screening> getScreeningsByTheatreIdAndCityIdAndDate(Long cityId, Long theatreId, LocalDate date);

    List<Screening> getScreeningsByMovieIdAndCityId(Long cityId,Long movieId);
    List<Screening> getScreeningsByMovieIdAndCityIdAndDate(Long cityId, Long movieId, LocalDate date);
}
