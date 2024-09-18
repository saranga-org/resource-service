package FuelPass.Dev.FuelPass.Controller;

import FuelPass.Dev.FuelPass.Service.OtpVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/otp")
@AllArgsConstructor
public class UserVerificationController {

    @Autowired
    private final OtpVerificationService otpVerificationService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateOtp() {
        try {
            String response = otpVerificationService.generateOtp();
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("Failed to generate OTP: " + e.getMessage());
        }
    }

    @PostMapping("/verify")
    public Boolean verifyOtp(@RequestParam String otp) {
        return otpVerificationService.verifyOtp(otp);
    }
}
