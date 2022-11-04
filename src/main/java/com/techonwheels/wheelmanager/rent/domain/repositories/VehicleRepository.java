package com.techonwheels.wheelmanager.rent.domain.repositories;

import com.techonwheels.wheelmanager.rent.domain.data.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
}
