package FuelPass.Dev.FuelPass.Service;

import FuelPass.Dev.FuelPass.DTO.VehicleDTO;
import FuelPass.Dev.FuelPass.Entity.User;
import FuelPass.Dev.FuelPass.Entity.Vehicle;
import FuelPass.Dev.FuelPass.Repo.VehicleRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private ModelMapper modelMapper;
//    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO){
//        vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class));
//        return vehicleDTO;
//    }

    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO){
        if (vehicleDTO.getRegNo() == null || vehicleDTO.getChassisNo() == null ||
                vehicleDTO.getVehicleType() == null || vehicleDTO.getFuelType() == null) {
            throw new IllegalArgumentException("Fields cannot be null");
        }
        vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class));
        return vehicleDTO;
    }


    public List<VehicleDTO> getAllVehicles(){

        List<Vehicle>vehicleList = vehicleRepo.findAll();
        return modelMapper.map(vehicleList, new TypeToken<List<VehicleDTO>>(){}.getType());
    }

    public boolean deleteVehicle(VehicleDTO vehicleDTO){
        vehicleRepo.delete(modelMapper.map(vehicleDTO, Vehicle.class));
        return true;
    }
}
