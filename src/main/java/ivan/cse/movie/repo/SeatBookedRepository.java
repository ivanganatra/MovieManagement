package ivan.cse.movie.repo;

import ivan.cse.movie.model.SeatBooked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatBookedRepository extends JpaRepository<SeatBooked, Long> {
}
