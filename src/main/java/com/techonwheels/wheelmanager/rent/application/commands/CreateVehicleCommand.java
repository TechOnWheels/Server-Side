package com.techonwheels.wheelmanager.rent.application.commands;

import com.techonwheels.wheelmanager.profile.domain.data.Customer;
import com.techonwheels.wheelmanager.rent.domain.valueobjects.Brand;
import com.techonwheels.wheelmanager.rent.domain.valueobjects.Status;
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
    private Status status;
    private Brand brand;
    private String type;
    private String ownerId;
}
