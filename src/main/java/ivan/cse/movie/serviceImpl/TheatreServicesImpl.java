package ivan.cse.movie.serviceImpl;

import ivan.cse.movie.message.request.CreateTheatreForm;
import ivan.cse.movie.model.City;
import ivan.cse.movie.model.Theatre;
import ivan.cse.movie.repo.CityRepository;
import ivan.cse.movie.repo.TheatreRepository;
import ivan.cse.movie.service.TheatreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServicesImpl implements TheatreServices {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    CityRepository cityRepository;

    public List<Theatre> getAllTheatres(){
        return theatreRepository.findAll();
    }

    public List<Theatre> getTheatresByCityName(String cityName){
        return theatreRepository.findByCityName(cityName);
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

