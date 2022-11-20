package com.techonwheels.wheelmanager.maintenance.domain.repositories;

import com.techonwheels.wheelmanager.maintenance.infrastructure.data.Maintenance;
import com.techonwheels.wheelmanager.rent.infrastructure.data.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, String> {
    List<Maintenance> findMaintenancesByMaintenanceVehicleTypeId(VehicleType maintenanceVehicleTypeId);
}
