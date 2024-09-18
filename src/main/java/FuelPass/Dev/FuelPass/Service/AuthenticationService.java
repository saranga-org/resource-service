package FuelPass.Dev.FuelPass.Service;

import FuelPass.Dev.FuelPass.Auth.AuthenticationRequest;
import FuelPass.Dev.FuelPass.Auth.AuthenticationResponse;
import FuelPass.Dev.FuelPass.Auth.RegisterRequest;
import FuelPass.Dev.FuelPass.Entity.User;
import FuelPass.Dev.FuelPass.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .userName(request.getUserName())
                .idType(request.getIdType())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(request.getRole())
                .contactNumber(request.getContactNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .isVerified(Boolean.FALSE)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken((UserDetails) user);
        var isVerified = false;
        return AuthenticationResponse.builder().token(jwtToken).isVerified(isVerified).build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );
        var user = userRepository.findById(request.getUserName())
                .orElseThrow();
        var isVerified = user.getIsVerified();
        var jwtToken = jwtService.generateToken((UserDetails) user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .isVerified(isVerified)
                .build();
    }

    public String getUserContactNumber() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("User not authenticated");
        }
        String userName = authentication.getName();
        var user = userRepository.findById(userName)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        return user.getContactNumber();
    }

    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("User not authenticated");
        }
        return authentication.getName();
    }

}
