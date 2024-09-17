package FuelPass.Dev.FuelPass.Repo;

import FuelPass.Dev.FuelPass.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
}
