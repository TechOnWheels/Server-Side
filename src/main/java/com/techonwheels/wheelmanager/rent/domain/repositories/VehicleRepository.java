package com.techonwheels.wheelmanager.rent.domain.repositories;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import com.techonwheels.wheelmanager.rent.infrastructure.data.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    List<Vehicle> findVehiclesByVehicleTypeId(VehicleType vehicleTypeId);
    
    List<Vehicle> findVehiclesByOwnerId(Customer ownerId);
}
