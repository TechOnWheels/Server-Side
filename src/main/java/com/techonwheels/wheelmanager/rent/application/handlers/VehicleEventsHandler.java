package com.techonwheels.wheelmanager.rent.application.handlers;

import com.techonwheels.wheelmanager.rent.application.events.VehicleCreatedEvent;
import com.techonwheels.wheelmanager.rent.domain.data.Vehicle;
import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("vehicle")
public class VehicleEventsHandler {
    private final VehicleRepository vehicleRepository;
    
    public VehicleEventsHandler(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    
    @EventHandler
    public void on(VehicleCreatedEvent vehicleCreatedEvent) {
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(vehicleCreatedEvent, vehicle);
        vehicleRepository.save(vehicle);
    }
}
