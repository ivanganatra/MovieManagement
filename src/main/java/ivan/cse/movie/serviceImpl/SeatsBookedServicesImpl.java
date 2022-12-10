package ivan.cse.movie.serviceImpl;

import ivan.cse.movie.message.request.CreateSeatBookedForm;
import ivan.cse.movie.model.SeatBooked;
import ivan.cse.movie.repo.AuditoriumRepository;
import ivan.cse.movie.repo.BookingRepository;
import ivan.cse.movie.repo.SeatBookedRepository;
import ivan.cse.movie.repo.SeatRepository;
import ivan.cse.movie.service.SeatBookedServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsBookedServicesImpl implements SeatBookedServices {

    @Autowired
    SeatBookedRepository seatBookedRepository;

    @Autowired
    SeatRepository seatRepository;

    @Autowired
    BookingRepository bookingRepository;


    public List<SeatBooked> getAllSeatBooked(){
        return seatBookedRepository.findAll();
    }

    public String addSeatBooked(CreateSeatBookedForm createSeatBookedForm) throws DataIntegrityViolationException{
        try {
            for(Long seatId:createSeatBookedForm.getSeats())
            {
                System.out.println(seatId+"dddddddddd");
                SeatBooked seatBooked = new SeatBooked();
                seatBooked.setSeat(seatRepository.getOne(seatId));
                seatBooked.setBooking(bookingRepository.getOne(createSeatBookedForm.getBookingId()));
                seatBooked.setScreening(bookingRepository.getOne(createSeatBookedForm.getBookingId()).getScreening());
                seatBookedRepository.save(seatBooked);
            }

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("SeatBooked already Exists.");
        }
        return "SeatBooked added successfully";
    }
}

