package ivan.cse.movie.repo;

import ivan.cse.movie.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {


    List<Theatre> findByCityName(String cityName);
}
