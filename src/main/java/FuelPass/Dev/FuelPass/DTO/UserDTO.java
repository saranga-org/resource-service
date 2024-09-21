package FuelPass.Dev.FuelPass.DTO;

import FuelPass.Dev.FuelPass.Entity.IdType;
import FuelPass.Dev.FuelPass.Entity.Role;
import FuelPass.Dev.FuelPass.Entity.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class UserDTO {
    private String userName;
    private String firstName;
    private String lastName;
    private IdType idType;
    private Role role;
    private String  contactNumber;
    private Boolean isVerified;
    private List<Vehicle> vehicles;
}
