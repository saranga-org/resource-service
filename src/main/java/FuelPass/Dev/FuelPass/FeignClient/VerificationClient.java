package FuelPass.Dev.FuelPass.FeignClient;

import FuelPass.Dev.FuelPass.DTO.VerifyOtpDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "message-service", url = "http://localhost:8083/api/verify")
public interface VerificationClient {

    @PostMapping("/generate-otp")
    public ResponseEntity<String> generateOtp(@RequestParam("phoneNumber") String phoneNumber);

    @PostMapping("/verify-otp")
    public boolean verifyOtp(@RequestBody VerifyOtpDTO verifyOtpDTO);
}
