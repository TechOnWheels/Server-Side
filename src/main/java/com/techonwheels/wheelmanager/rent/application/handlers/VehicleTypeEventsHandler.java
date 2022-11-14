package com.techonwheels.wheelmanager.rent.application.handlers;

import com.techonwheels.wheelmanager.rent.application.events.VehicleTypeCreatedEvent;
import com.techonwheels.wheelmanager.rent.infrastructure.data.VehicleType;
import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleTypeRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("type")
public class VehicleTypeEventsHandler {
    private final VehicleTypeRepository vehicleTypeRepository;
    
    public VehicleTypeEventsHandler(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }
    
    @EventHandler
    public void on(VehicleTypeCreatedEvent vehicleTypeCreatedEvent) {
        VehicleType vehicleType = new VehicleType();
        BeanUtils.copyProperties(vehicleTypeCreatedEvent, vehicleType);
        vehicleTypeRepository.save(vehicleType);
    }
}
