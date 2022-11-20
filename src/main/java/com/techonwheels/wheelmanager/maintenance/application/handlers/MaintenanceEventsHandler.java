package com.techonwheels.wheelmanager.maintenance.application.handlers;

import com.techonwheels.wheelmanager.maintenance.application.events.MaintenanceCreatedEvent;
import com.techonwheels.wheelmanager.maintenance.domain.repositories.MaintenanceRepository;
import com.techonwheels.wheelmanager.maintenance.infrastructure.data.Maintenance;
import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleTypeRepository;
import com.techonwheels.wheelmanager.rent.infrastructure.data.VehicleType;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ProcessingGroup("maintenance")
public class MaintenanceEventsHandler {
    private final MaintenanceRepository maintenanceRepository;
    private final VehicleTypeRepository vehicleTypeRepository;
    
    public MaintenanceEventsHandler(MaintenanceRepository maintenanceRepository,
                                    VehicleTypeRepository vehicleTypeRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
    }
    
    @EventHandler
    public void on(MaintenanceCreatedEvent maintenanceCreatedEvent) {
        Maintenance maintenance = new Maintenance();
        BeanUtils.copyProperties(maintenanceCreatedEvent, maintenance);
        Optional<VehicleType> vehicleTypeOptional =
                vehicleTypeRepository.findById(maintenanceCreatedEvent.getMaintenanceVehicleTypeId());
        vehicleTypeOptional.ifPresent(maintenance::setMaintenanceVehicleTypeId);
        maintenanceRepository.save(maintenance);
    }
}
