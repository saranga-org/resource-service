package FuelPass.Dev.FuelPass.DTO;

import FuelPass.Dev.FuelPass.Entity.IdType;
import FuelPass.Dev.FuelPass.Entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private Role role;
    private String  contactNumber;
    private Boolean isVerified;
}
