package ivan.cse.movie.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ivan.cse.movie.message.request.CreateCityForm;
import ivan.cse.movie.model.City;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityServices {
    List<City> getAllCities();
    String addCity(CreateCityForm createCityForm);
}
