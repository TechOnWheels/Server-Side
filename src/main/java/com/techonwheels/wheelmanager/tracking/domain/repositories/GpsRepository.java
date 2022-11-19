package com.techonwheels.wheelmanager.tracking.domain.repositories;

import com.techonwheels.wheelmanager.tracking.infrastructure.data.Gps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GpsRepository extends JpaRepository<Gps, String> {
    Optional<Gps> findByLatitudeGpsAndLongitudeGps(Double latitudeGps, Double longitudeGps);
}
