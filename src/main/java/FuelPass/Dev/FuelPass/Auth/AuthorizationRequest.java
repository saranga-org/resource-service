package FuelPass.Dev.FuelPass.Auth;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationRequest {
    private String jwt;
}
