package ivan.cse.movie.serviceImpl;

import ivan.cse.movie.message.request.CreateTheatreForm;
import ivan.cse.movie.model.*;
import ivan.cse.movie.model.Theatre;
import ivan.cse.movie.repo.CityRepository;
import ivan.cse.movie.repo.ScreeningRepository;
import ivan.cse.movie.repo.TheatreRepository;
import ivan.cse.movie.service.TheatreServices;
import javafx.stage.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServicesImpl implements TheatreServices {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ScreeningRepository screeningRepository;

    public List<Theatre> getAllTheatres(){
        return theatreRepository.findAll();
    }

    public List<Theatre> getTheatresByCityId(Long cityId){
        return theatreRepository.findByCityId(cityId);
    }

    public List<Theatre> getTheatresByMovieIdAndCityId(Long cityId, Long movieId){
        List<Screening> allScreenings=screeningRepository.findByMovieIdAndCityId(movieId,cityId);
        List<Theatre> allTheatres = new ArrayList<Theatre>();
        for(Screening s:allScreenings)
        {
            allTheatres.add(s.getAuditorium().getTheatre());
        }
        return allTheatres;
    }
    public List<Theatre> getTheatresByMovieIdAndCityIdAndDate(Long cityId, Long movieId, LocalDate date){
        List<Screening> allScreenings=screeningRepository.findByMovieIdAndCityIdAndDate(movieId,cityId,date);
        List<Theatre> allTheatres = new ArrayList<Theatre>();
        for(Screening s:allScreenings)
        {
            allTheatres.add(s.getAuditorium().getTheatre());
        }
        return allTheatres;
    }
    
    public String addTheatre(CreateTheatreForm createTheatreForm) throws DataIntegrityViolationException{
        try {
            Theatre theatre = new Theatre();
            theatre.setName(createTheatreForm.getName());
            theatre.setCity(cityRepository.getOne(createTheatreForm.getCityId()));
            theatreRepository.save(theatre);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Theatre already Exists.");
        }
        return "Theatre added successfully";
    }
}

