package FuelPass.Dev.FuelPass.DTO;

import FuelPass.Dev.FuelPass.Entity.FuelType;
import FuelPass.Dev.FuelPass.Entity.VehicleType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDTO {
//    private int id;
    private String regNo;
    private String chassisNo;
    private VehicleType vehicleType;
    private FuelType fuelType;
}
