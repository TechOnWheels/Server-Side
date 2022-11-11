package com.techonwheels.wheelmanager.rent.domain.repositories;

import com.techonwheels.wheelmanager.rent.infrastructure.data.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, String> {
}
