package ivan.cse.movie.serviceImpl;

import ivan.cse.movie.message.request.CreateBookingForm;
import ivan.cse.movie.model.Screening;
import ivan.cse.movie.model.Booking;
import ivan.cse.movie.repo.AuditoriumRepository;
import ivan.cse.movie.repo.ScreeningRepository;
import ivan.cse.movie.repo.BookingRepository;
import ivan.cse.movie.repo.UserRepository;
import ivan.cse.movie.service.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class   BookingServicesImpl implements BookingServices {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ScreeningRepository screeningRepository;


    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    public String addBooking(CreateBookingForm createBookingForm) throws DataIntegrityViolationException{
        try {
            Booking booking = new Booking();
            booking.setBookingTime(createBookingForm.getBookingTime());
            booking.setBooked(createBookingForm.isBooked());
            booking.setActive(createBookingForm.isActive());
            booking.setScreening(screeningRepository.getOne(createBookingForm.getScreeningId()));
            booking.setUser(userRepository.getOne(createBookingForm.getUserId()));
            bookingRepository.save(booking);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Booking already Exists.");
        }
        return "Booking added successfully";
    }
}

