package com.techonwheels.wheelmanager.tracking.domain.aggregates;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import com.techonwheels.wheelmanager.tracking.application.commands.CreateGpsCommand;
import com.techonwheels.wheelmanager.tracking.application.events.GpsCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class GpsAggregate {
    @AggregateIdentifier
    private String gpsId;
    private Double latitudeGps;
    private Double longitudeGps;
    private Address addressGps;
    private String gpsVehicleOwnerId;
    
    public GpsAggregate() {
    }
    
    @CommandHandler
    public GpsAggregate(CreateGpsCommand createGpsCommand) {
        GpsCreatedEvent gpsCreatedEvent = new GpsCreatedEvent();
        BeanUtils.copyProperties(createGpsCommand, gpsCreatedEvent);
        AggregateLifecycle.apply(gpsCreatedEvent);
    }
    
    @EventSourcingHandler
    public void on(GpsCreatedEvent gpsCreatedEvent) {
        this.gpsId = gpsCreatedEvent.getGpsId();
        this.latitudeGps = gpsCreatedEvent.getLatitudeGps();
        this.longitudeGps = gpsCreatedEvent.getLongitudeGps();
        this.addressGps = gpsCreatedEvent.getAddressGps();
        this.gpsVehicleOwnerId = gpsCreatedEvent.getGpsVehicleOwnerId();
    }
}
