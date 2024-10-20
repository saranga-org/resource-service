package FuelPass.Dev.FuelPass.Controller;

import FuelPass.Dev.FuelPass.Auth.AuthenticationResponse;
import FuelPass.Dev.FuelPass.Auth.AuthorizationRequest;
import FuelPass.Dev.FuelPass.Auth.AuthorizationResponse;
import FuelPass.Dev.FuelPass.Entity.Role;
import FuelPass.Dev.FuelPass.Service.AuthenticationService;
import FuelPass.Dev.FuelPass.Service.JwtService;
import FuelPass.Dev.FuelPass.Service.ServiceAccessService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ServiceAccessController {
    @Autowired
    public JwtService jwtService;
    @Autowired
    public ServiceAccessService serviceAccessService;
    @Autowired
    private  AuthenticationService service;

    @GetMapping("/fuel-quota")
    public ResponseEntity<AuthorizationResponse> fuelQuota() {
        try{
            return ResponseEntity.ok(serviceAccessService.getOperator(service.getCurrentUser()));
        }catch(RuntimeException e){
            return ResponseEntity.ok(serviceAccessService.getOperator(service.getCurrentUser()));
        }

    }

    @GetMapping("/vehicle-service")
    public ResponseEntity<AuthorizationResponse> vehicleService(){
        try{
            return ResponseEntity.ok(serviceAccessService.getUser(service.getCurrentUser()));
        }catch(RuntimeException e){
            return ResponseEntity.ok(serviceAccessService.getUser(service.getCurrentUser()));
        }
    }
}
