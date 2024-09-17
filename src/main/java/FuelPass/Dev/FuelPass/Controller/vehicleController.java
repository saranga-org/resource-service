package FuelPass.Dev.FuelPass.Controller;

import FuelPass.Dev.FuelPass.DTO.VehicleDTO;
import FuelPass.Dev.FuelPass.Repo.VehicleRepo;
import FuelPass.Dev.FuelPass.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/deleteVehicle")
    public boolean deleteVehicle(@RequestBody VehicleDTO vehicleDTO){
        return  vehicleService.deleteVehicle(vehicleDTO);
    }
    
}
