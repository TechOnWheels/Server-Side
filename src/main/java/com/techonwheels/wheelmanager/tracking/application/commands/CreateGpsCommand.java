package com.techonwheels.wheelmanager.tracking.application.commands;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateGpsCommand {
    @TargetAggregateIdentifier
    private String gpsId;
    private Double latitudeGps;
    private Double longitudeGps;
    private Address addressGps;
    private String gpsVehicleOwnerId;
}
