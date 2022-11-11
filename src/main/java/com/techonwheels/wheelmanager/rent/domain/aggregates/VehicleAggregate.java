package com.techonwheels.wheelmanager.rent.domain.aggregates;

import com.techonwheels.wheelmanager.rent.application.commands.CreateVehicleCommand;
import com.techonwheels.wheelmanager.rent.application.events.VehicleCreatedEvent;
import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Brand;
import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Status;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class VehicleAggregate {
    @AggregateIdentifier
    private String vehicleId;
    private String vehicleName;
    private String imageURL;
    private String description;
    private Double price;
    private Double qualification;
    private Status status;
    private Brand brand;
    private String vehicleTypeId;
    private String ownerId;
    
    public VehicleAggregate() {
    
    }
    
    @CommandHandler
    public VehicleAggregate(CreateVehicleCommand createVehicleCommand) {
        VehicleCreatedEvent vehicleCreatedEvent = new VehicleCreatedEvent();
        BeanUtils.copyProperties(createVehicleCommand, vehicleCreatedEvent);
        AggregateLifecycle.apply(vehicleCreatedEvent);
    }
    
    @EventSourcingHandler
    public void on(VehicleCreatedEvent vehicleCreatedEvent) {
        this.vehicleId = vehicleCreatedEvent.getVehicleId();
        this.vehicleName = vehicleCreatedEvent.getVehicleName();
        this.imageURL = vehicleCreatedEvent.getImageURL();
        this.description = vehicleCreatedEvent.getDescription();
        this.price = vehicleCreatedEvent.getPrice();
        this.qualification = vehicleCreatedEvent.getQualification();
        this.status = vehicleCreatedEvent.getStatus();
        this.brand = vehicleCreatedEvent.getBrand();
        this.vehicleTypeId = vehicleCreatedEvent.getVehicleTypeId();
        this.ownerId = vehicleCreatedEvent.getOwnerId();
    }
}
