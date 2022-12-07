package ivan.cse.movie.repo;

import ivan.cse.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {


    List<Movie> findByCityId(String cityId);
}
