package ivan.cse.movie.repo;

import ivan.cse.movie.model.Auditorium;
import ivan.cse.movie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByAuditorium(Auditorium auditorium);
}
