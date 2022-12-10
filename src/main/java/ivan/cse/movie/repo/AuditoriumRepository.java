package ivan.cse.movie.repo;

import ivan.cse.movie.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {


    List<Auditorium> findByTheatreId(Long theatreId);

    List<Auditorium> findByCityId(Long cityId);
}
