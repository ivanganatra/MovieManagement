package ivan.cse.movie.serviceImpl;

import ivan.cse.movie.message.request.CreateSeatForm;
import ivan.cse.movie.model.Screening;
import ivan.cse.movie.model.Seat;
import ivan.cse.movie.repo.AuditoriumRepository;
import ivan.cse.movie.repo.ScreeningRepository;
import ivan.cse.movie.repo.SeatRepository;
import ivan.cse.movie.repo.TheatreRepository;
import ivan.cse.movie.service.SeatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsServicesImpl implements SeatServices {

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Autowired
    ScreeningRepository screeningRepository;


    public List<Seat> getAllSeats(){
        return seatRepository.findAll();
    }


    public List<Seat> getSeatsByScreening(Long screeningId){
        Screening screen=screeningRepository.getOne(screeningId);
        return seatRepository.findByAuditorium(screen.getAuditorium());
    }

    public String addSeat(CreateSeatForm createSeatForm) throws DataIntegrityViolationException{
        try {
            Seat seat = new Seat();
            seat.setSeatNumber(createSeatForm.getSeatNumber());
            seat.setSeatType(createSeatForm.getSeatType());
            seat.setSeatStatus(createSeatForm.getSeatStatus());
            seat.setAuditorium(auditoriumRepository.getOne(createSeatForm.getAuditoriumId()));
            seatRepository.save(seat);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Seat already Exists.");
        }
        return "Seat added successfully";
    }
}

