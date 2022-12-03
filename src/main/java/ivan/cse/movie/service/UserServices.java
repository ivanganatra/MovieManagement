package ivan.cse.movie.service;

import ivan.cse.movie.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers();
}
