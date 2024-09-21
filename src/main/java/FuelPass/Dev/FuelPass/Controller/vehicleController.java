package FuelPass.Dev.FuelPass.Controller;

import FuelPass.Dev.FuelPass.DTO.VehicleDTO;
import FuelPass.Dev.FuelPass.Repo.VehicleRepo;
import FuelPass.Dev.FuelPass.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v/vehicle")
@CrossOrigin

public class vehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/getVehicles")
    public List<VehicleDTO> getVehicles(){
        return vehicleService.getAllVehicles();
    }

    @PostMapping("/saveVehicle")
    public VehicleDTO saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        return vehicleService.saveVehicle(vehicleDTO);
    }

    @DeleteMapping("/deleteVehicle/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Integer id){
        try{
            boolean isDeleted =   vehicleService.deleteVehicle(id);
            if (isDeleted) {
                return ResponseEntity.ok("Vehicle deleted successfully!");
            } else {
                return ResponseEntity.status(404).body("Vehicle not found!");
            }
        }catch (Exception e){
            return ResponseEntity.status(500).body("Failed to delete vehicle: " + e.getMessage());
        }

    }
    
}
