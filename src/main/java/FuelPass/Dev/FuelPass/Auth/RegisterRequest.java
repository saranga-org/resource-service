package FuelPass.Dev.FuelPass.Auth;

import FuelPass.Dev.FuelPass.Entity.IdType;
import FuelPass.Dev.FuelPass.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String userName;
    private IdType idType;
    private Role role;
    private String  contactNumber;
    private String firstName;
    private String lastName;
    private String password;

}

