package com.techonwheels.wheelmanager.rent.application.commands;

import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Brand;
import com.techonwheels.wheelmanager.rent.infrastructure.valueobjects.Status;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class CreateVehicleCommand {
    @TargetAggregateIdentifier
    private String vehicleId;
    private String vehicleName;
    private String imageURL;
    private String description;
    private BigDecimal price;
    private Double qualification;
    private Status status;
    private Brand brand;
    private String vehicleTypeId;
    private String ownerId;
}
