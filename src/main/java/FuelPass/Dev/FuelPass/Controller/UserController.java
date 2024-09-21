package FuelPass.Dev.FuelPass.Controller;


import FuelPass.Dev.FuelPass.DTO.UserDTO;
import FuelPass.Dev.FuelPass.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }

    @GetMapping("/getAllUsers")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

}
