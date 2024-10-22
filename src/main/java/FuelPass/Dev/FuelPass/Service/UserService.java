package FuelPass.Dev.FuelPass.Service;

import FuelPass.Dev.FuelPass.Entity.User;
import FuelPass.Dev.FuelPass.Repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public boolean verifyUser(String userName) {
        Optional<User> currentUser = userRepo.findById(userName);
        return currentUser.map(user -> {
            user.setIsVerified(true);
            userRepo.save(user);
            return true;
        }).orElse(false);
    }

}
