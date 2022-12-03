package ivan.cse.movie.repo;

import ivan.cse.movie.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {


}
