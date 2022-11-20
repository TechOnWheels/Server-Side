package com.techonwheels.wheelmanager.tracking.application.handlers;

import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleRepository;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import com.techonwheels.wheelmanager.tracking.application.events.GpsCreatedEvent;
import com.techonwheels.wheelmanager.tracking.domain.repositories.GpsRepository;
import com.techonwheels.wheelmanager.tracking.infrastructure.data.Gps;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ProcessingGroup("tracking")
public class GpsEventsHandler {
    private final GpsRepository gpsRepository;
    private final VehicleRepository vehicleRepository;
    
    public GpsEventsHandler(GpsRepository gpsRepository, VehicleRepository vehicleRepository) {
        this.gpsRepository = gpsRepository;
        this.vehicleRepository = vehicleRepository;
    }
    
    @EventHandler
    public void on(GpsCreatedEvent gpsCreatedEvent) {
        Gps gps = new Gps();
        BeanUtils.copyProperties(gpsCreatedEvent, gps);
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(gpsCreatedEvent.getGpsVehicleOwnerId());
        vehicleOptional.ifPresent(gps::setGpsVehicleOwnerId);
        gpsRepository.save(gps);
    }
}
