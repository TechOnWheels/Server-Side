package com.techonwheels.wheelmanager.maintenance.domain.aggregates;

import com.techonwheels.wheelmanager.maintenance.application.commands.CreateMaintenanceCommand;
import com.techonwheels.wheelmanager.maintenance.application.events.MaintenanceCreatedEvent;
import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class MaintenanceAggregate {
    @AggregateIdentifier
    private String maintenanceId;
    private String maintenanceName;
    private String maintenanceDetail;
    private BigDecimal maintenancePrice;
    private Address addressMaintenance;
    private String maintenanceVehicleTypeId;
    
    public MaintenanceAggregate() {
    }
    
    @CommandHandler
    public MaintenanceAggregate(CreateMaintenanceCommand createMaintenanceCommand) {
        MaintenanceCreatedEvent maintenanceCreatedEvent = new MaintenanceCreatedEvent();
        BeanUtils.copyProperties(createMaintenanceCommand, maintenanceCreatedEvent);
        AggregateLifecycle.apply(maintenanceCreatedEvent);
    }
    
    @EventSourcingHandler
    public void on(MaintenanceCreatedEvent maintenanceCreatedEvent) {
        this.maintenanceId = maintenanceCreatedEvent.getMaintenanceId();
        this.maintenanceName = maintenanceCreatedEvent.getMaintenanceName();
        this.maintenanceDetail = maintenanceCreatedEvent.getMaintenanceDetail();
        this.maintenancePrice = maintenanceCreatedEvent.getMaintenancePrice();
        this.addressMaintenance = maintenanceCreatedEvent.getAddressMaintenance();
        this.maintenanceVehicleTypeId = maintenanceCreatedEvent.getMaintenanceVehicleTypeId();
    }
}
