package ivan.cse.movie.repo;

import ivan.cse.movie.model.City;
import ivan.cse.movie.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {


    List<Theatre> findByCityId(String cityId);

    @Query(value="select city_id from movie.theatre where theatre_id= ?1",nativeQuery=true )
    Long getCityIdById(Long theatreId);
}
