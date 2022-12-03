package ivan.cse.movie.serviceImpl;

import antlr.ASTNULLType;
import ivan.cse.movie.model.User;
import ivan.cse.movie.repo.UserRepository;
import ivan.cse.movie.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();

    }
}
