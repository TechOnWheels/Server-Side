package com.techonwheels.wheelmanager.rent.application.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateVehicleCommand {
    @TargetAggregateIdentifier
    private String vehicleId;
    private String vehicleName;
    private String imageURL;
    private String description;
    private Double price;
    private Double qualification;
    private String status;
    private String brand;
    private String type;
    private String ownerId;
}
