package FuelPass.Dev.FuelPass.Service;

import FuelPass.Dev.FuelPass.DTO.VerifyOtpDTO;
import FuelPass.Dev.FuelPass.FeignClient.VerificationClient;
import FuelPass.Dev.FuelPass.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpVerificationService {
    @Autowired
    private VerificationClient verificationClient;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;


    public String generateOtp() {
        return verificationClient.generateOtp(authenticationService.getUserContactNumber()).getBody();
    }

    public boolean verifyOtp(String otp) {
        VerifyOtpDTO verifyOtpDTO = new VerifyOtpDTO();
        verifyOtpDTO.setOtpCode(otp);
        verifyOtpDTO.setPhoneNumber(authenticationService.getUserContactNumber());

        if(verificationClient.verifyOtp(verifyOtpDTO)){
                userService.verifyUser(authenticationService.getCurrentUser());
                return true;
        }else{
            return false;
        }

    }
}
