package FuelPass.Dev.FuelPass.Service;

import FuelPass.Dev.FuelPass.DTO.UserDTO;
import FuelPass.Dev.FuelPass.Entity.User;
import FuelPass.Dev.FuelPass.Repo.UserRepo;
import FuelPass.Dev.FuelPass.Repo.VehicleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    public void verifyUser(String userName){
        Optional<User> currentUser = userRepo.findById(userName);
        currentUser.ifPresent(user -> user.setIsVerified(true));
    }
}
