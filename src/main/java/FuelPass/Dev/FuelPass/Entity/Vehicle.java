package FuelPass.Dev.FuelPass.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehicle {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "regNO", nullable = false)
    private String regNo;

    @Column(name = "chassisNo", nullable = false)
    private String chassisNo;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "vehicleType", nullable = false)
    private VehicleType vehicleType;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "fuelType", nullable = false)
    private FuelType fuelType;

}
