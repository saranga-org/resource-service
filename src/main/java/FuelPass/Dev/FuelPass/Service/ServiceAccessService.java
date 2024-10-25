package FuelPass.Dev.FuelPass.Service;

import FuelPass.Dev.FuelPass.Auth.AuthenticationResponse;
import FuelPass.Dev.FuelPass.Auth.AuthorizationResponse;
import FuelPass.Dev.FuelPass.Entity.Role;
import FuelPass.Dev.FuelPass.Entity.User;
import FuelPass.Dev.FuelPass.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ServiceAccessService {
 @Autowired
    private UserRepo userRepository;
 @Autowired
    private JwtService jwtService;
 @Autowired
    private  AuthenticationService service;

//    public boolean getOperator(String userName) {
//
//        Optional<User> user = userRepository.findByUserName(userName);
//
//        if (user.isPresent()){
//            System.out.println(user.get().getRole());
//            if(user.get().getRole().equals(Role.STATION_OWNER)){
//                  System.out.println("role matchs");
//                return true;
//            }
//            System.out.println("role doesnt match");
//            return false;
//        }
//        System.out.println("no user");
//        return false;
//
//    }

    public AuthorizationResponse getOperator(String userName) {

        Optional<User> user = userRepository.findByUserName(userName);

        if (user.isPresent()){
            System.out.println(user.get().getRole());
            if(user.get().getRole().equals(Role.STATION_OWNER)){
                System.out.println(user.get().getUsername());
                return AuthorizationResponse.builder()
                        .userName(user.get().getUsername())
                        .build();
            }
            return AuthorizationResponse.builder()
                    .userName(null)
                    .build();
        }

        return AuthorizationResponse.builder()
                .userName(null)
                .build();
    }


     public AuthorizationResponse getUser(String userName) {

        Optional<User> user = userRepository.findByUserName(userName);

        if (user.isPresent()){
            System.out.println(user.get().getRole());
            if(user.get().getRole().equals(Role.USER)){
                System.out.println(user.get().getUsername());
                return AuthorizationResponse.builder()
                        .userName(user.get().getUsername())
                        .build();
            }
            return AuthorizationResponse.builder()
                    .userName(null)
                    .build();
        }

         return AuthorizationResponse.builder()
                 .userName(null)
                 .build();

    }
}
