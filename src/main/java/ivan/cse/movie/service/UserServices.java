package ivan.cse.movie.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ivan.cse.movie.message.request.CreateUserForm;
import ivan.cse.movie.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServices {
    List<User> getAllUsers();
    String createUser(CreateUserForm createUserForm);
}
