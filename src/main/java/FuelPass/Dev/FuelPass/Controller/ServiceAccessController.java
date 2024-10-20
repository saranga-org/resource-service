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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/serviceAccess")
public class ServiceAccessController {
    @Autowired
    public JwtService jwtService;
    @Autowired
    public ServiceAccessService serviceAccessService;
    @Autowired
    private  AuthenticationService service;



        @PostMapping("/fuelQuota")
        public ResponseEntity<AuthorizationResponse> fuelQuota() {
            try{
                return ResponseEntity.ok(serviceAccessService.getOperator(service.getCurrentUser()));
            }catch(RuntimeException e){
                return ResponseEntity.ok(serviceAccessService.getOperator(service.getCurrentUser()));
            }

        }


    @PostMapping("/vehicleService")
    public ResponseEntity<AuthorizationResponse> vehicleService(){
        try{
            return ResponseEntity.ok(serviceAccessService.getUser(service.getCurrentUser()));
        }catch(RuntimeException e){
            return ResponseEntity.ok(serviceAccessService.getUser(service.getCurrentUser()));
        }
    }
}
