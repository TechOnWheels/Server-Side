package com.techonwheels.wheelmanager.rent.domain.aggregates;

import com.techonwheels.wheelmanager.rent.application.commands.CreateVehicleTypeCommand;
import com.techonwheels.wheelmanager.rent.application.events.VehicleTypeCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class VehicleTypeAggregate {
    @AggregateIdentifier
    private String typeId;
    private String typeName;
    
    public VehicleTypeAggregate() {
    
    }
    
    @CommandHandler
    public VehicleTypeAggregate(CreateVehicleTypeCommand createVehicleTypeCommand) {
        VehicleTypeCreatedEvent vehicleTypeCreatedEvent = new VehicleTypeCreatedEvent();
        BeanUtils.copyProperties(createVehicleTypeCommand, vehicleTypeCreatedEvent);
        AggregateLifecycle.apply(vehicleTypeCreatedEvent);
    }
    
    @EventSourcingHandler
    public void on(VehicleTypeCreatedEvent vehicleTypeCreatedEvent) {
        this.typeId = vehicleTypeCreatedEvent.getTypeId();
        this.typeName = vehicleTypeCreatedEvent.getTypeName();
    }
}
