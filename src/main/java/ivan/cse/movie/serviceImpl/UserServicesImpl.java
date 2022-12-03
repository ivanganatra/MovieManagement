package ivan.cse.movie.serviceImpl;

import antlr.ASTNULLType;
import ivan.cse.movie.message.request.CreateUserForm;
import ivan.cse.movie.model.User;
import ivan.cse.movie.repo.UserRepository;
import ivan.cse.movie.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public String createUser(CreateUserForm createUserForm) throws DataIntegrityViolationException{
        try {
            User user = new User();
            user.setEmail(createUserForm.getEmail());
            user.setUsername(createUserForm.getUsername());
            user.setMobileNo(createUserForm.getMobileNo());
            user.setPassword(createUserForm.getPassword());
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("User already Exists.");
        }
        return "User added successfully";
    }
}
