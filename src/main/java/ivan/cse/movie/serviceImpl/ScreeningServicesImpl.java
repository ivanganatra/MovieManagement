package ivan.cse.movie.serviceImpl;

import ivan.cse.movie.message.request.CreateScreeningForm;
import ivan.cse.movie.model.Auditorium;
import ivan.cse.movie.model.Screening;
import ivan.cse.movie.repo.AuditoriumRepository;
import ivan.cse.movie.repo.MovieRepository;
import ivan.cse.movie.repo.ScreeningRepository;
import ivan.cse.movie.service.ScreeningServices;
import org.apache.commons.math3.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScreeningServicesImpl implements ScreeningServices {

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Autowired
    MovieRepository movieRepository;

    public List<Screening> getAllScreenings(){
        return screeningRepository.findAll();
    }

    public List<Screening> getScreeningsByTheatreIdAndCityId(Long cityId,Long theatreId){
        return screeningRepository.findByTheatreIdAndCityId(theatreId,cityId);
    }
    public List<Screening> getScreeningsByTheatreIdAndCityIdAndDate(Long cityId, Long theatreId, LocalDate date){
        return screeningRepository.findByTheatreIdAndCityIdAndDate(theatreId,cityId,date);
    }
    public List<Screening> getScreeningsByMovieIdAndCityId(Long cityId,Long movieId){
        return screeningRepository.findByMovieIdAndCityId(movieId,cityId);
    }
    public List<Screening> getScreeningsByMovieIdAndCityIdAndDate(Long cityId, Long movieId, LocalDate date){
        return screeningRepository.findByMovieIdAndCityIdAndDate(movieId,cityId,date);
    }
    public String addScreening(CreateScreeningForm createScreeningForm) throws DataIntegrityViolationException{
        try {
            Screening screening = new Screening();
            screening.setDate(createScreeningForm.getDate());
            screening.setIsFull(createScreeningForm.getIsFull());
            screening.setPrice(createScreeningForm.getPrice());
            screening.setMovie(movieRepository.getOne(createScreeningForm.getMovieId()));
            screening.setStartTime(createScreeningForm.getStartTime());
            screening.setEndTime(createScreeningForm.getEndTime());
            Auditorium save= auditoriumRepository.getOne(createScreeningForm.getAuditoriumId());
            screening.setAuditorium(save);
            screening.setCityId(save.getCityId());
            screening.setTheatreId(save.getTheatre().getId());
            screeningRepository.save(screening);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Screening already Exists.");
        }
        return "Screening added successfully";
    }
}

