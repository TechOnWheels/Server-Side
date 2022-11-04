package com.techonwheels.wheelmanager.rent.application.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateVehicleTypeCommand {
    @TargetAggregateIdentifier
    private String typeId;
    private String typeName;
}
