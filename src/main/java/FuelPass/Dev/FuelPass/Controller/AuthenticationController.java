package FuelPass.Dev.FuelPass.Controller;

import FuelPass.Dev.FuelPass.Auth.AuthenticationRequest;
import FuelPass.Dev.FuelPass.Auth.AuthenticationResponse;
import FuelPass.Dev.FuelPass.Auth.RegisterRequest;
import FuelPass.Dev.FuelPass.Service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/resource/auth")
@RequiredArgsConstructor

@Tag(name = "Auth Management", description = "Authentication Controller")
public class AuthenticationController {

    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
