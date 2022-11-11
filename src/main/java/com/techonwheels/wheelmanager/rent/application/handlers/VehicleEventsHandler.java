package com.techonwheels.wheelmanager.rent.application.handlers;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.profile.domain.repositories.CustomerRepository;
import com.techonwheels.wheelmanager.rent.application.events.VehicleCreatedEvent;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import com.techonwheels.wheelmanager.rent.infrastructure.data.VehicleType;
import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleRepository;
import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleTypeRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ProcessingGroup("vehicle")
public class VehicleEventsHandler {
    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;
    private final VehicleTypeRepository vehicleTypeRepository;
    
    public VehicleEventsHandler(VehicleRepository vehicleRepository, CustomerRepository customerRepository,
                                VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
    }
    
    @EventHandler
    public void on(VehicleCreatedEvent vehicleCreatedEvent) {
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties(vehicleCreatedEvent, vehicle);
        Optional<Customer> customerOptional = customerRepository.findById(vehicleCreatedEvent.getOwnerId());
        customerOptional.ifPresent(vehicle::setOwnerId);
        Optional<VehicleType> vehicleTypeOptional = vehicleTypeRepository.findById(vehicleCreatedEvent.getVehicleTypeId());
        vehicleTypeOptional.ifPresent(vehicle::setVehicleTypeId);
        vehicleRepository.save(vehicle);
    }
}
