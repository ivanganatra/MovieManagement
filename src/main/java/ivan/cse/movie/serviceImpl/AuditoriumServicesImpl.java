package ivan.cse.movie.serviceImpl;

import ivan.cse.movie.message.request.CreateAuditoriumForm;
import ivan.cse.movie.model.Auditorium;
import ivan.cse.movie.model.City;
import ivan.cse.movie.repo.TheatreRepository;
import ivan.cse.movie.repo.AuditoriumRepository;
import ivan.cse.movie.service.AuditoriumServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumServicesImpl implements AuditoriumServices {

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreRepository cityRepository;

    public List<Auditorium> getAllAuditoriums(){
        return auditoriumRepository.findAll();
    }

    public List<Auditorium> getAuditoriumsByTheatreId(String theatreId){
        return auditoriumRepository.findByTheatreId(theatreId);
    }
    public List<Auditorium> getAuditoriumsByCityId(String cityId){
        return auditoriumRepository.findByCityId(cityId);
    }

    public String addAuditorium(CreateAuditoriumForm createAuditoriumForm) throws DataIntegrityViolationException{
        try {
            Auditorium auditorium = new Auditorium();
            auditorium.setName(createAuditoriumForm.getName());
            auditorium.setSeatCount(createAuditoriumForm.getSeatCount());
            auditorium.setTheatre(theatreRepository.getOne(createAuditoriumForm.getTheatreId()));
             auditorium.setCityId(theatreRepository.getCityIdById(createAuditoriumForm.getTheatreId()));

            auditoriumRepository.save(auditorium);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Auditorium already Exists.");
        }
        return "Auditorium added successfully";
    }
}

