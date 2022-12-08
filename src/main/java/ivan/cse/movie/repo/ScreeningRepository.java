package ivan.cse.movie.repo;

import ivan.cse.movie.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {


    List<Screening> findByCityId(Long cityId);

    @Query(value="select city_id from movie.auditorium where auditorium_id= ?1",nativeQuery=true )
    Long getCityIdById(Long auditoriumId);

    @Query(value="select theatre_id from movie.auditorium where theatre_id= ?1",nativeQuery=true )
    Long getTheatreIdById(Long auditoriumId);

    List<Screening> findByTheatreIdAndCityId(Long theatreId, Long cityId);

    List<Screening> findByTheatreIdAndCityIdAndDate(Long theatreId, Long cityId, LocalDate date);

    List<Screening> findByMovieIdAndCityId(Long movieId, Long cityId);

    List<Screening> findByMovieIdAndCityIdAndDate(Long movieId, Long cityId, LocalDate date);
}
