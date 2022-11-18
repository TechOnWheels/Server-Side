package com.techonwheels.wheelmanager.community.application.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateFavoriteCommand {
    @TargetAggregateIdentifier
    private String favoriteId;
    private Boolean favoriteSelected;
    private String favoriteCustomerId;
    private String favoriteVehicleId;
}
