package ivan.cse.movie.serviceImpl;

import antlr.ASTNULLType;
import ivan.cse.movie.message.request.CreateCityForm;
import ivan.cse.movie.model.City;
import ivan.cse.movie.repo.CityRepository;
import ivan.cse.movie.service.CityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CityServicesImpl implements CityServices {

    @Autowired
    CityRepository cityRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }
    public String addCity(CreateCityForm createCityForm) throws DataIntegrityViolationException{
        try {
            City city = new City();
            city.setName(createCityForm.getName());
            cityRepository.save(city);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("City already Exists.");
        }
        return "City added successfully";
    }
}

