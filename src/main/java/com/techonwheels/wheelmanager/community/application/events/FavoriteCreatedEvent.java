package com.techonwheels.wheelmanager.community.application.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteCreatedEvent {
    private String favoriteId;
    private Boolean favoriteSelected;
    private String favoriteCustomerId;
    private String favoriteVehicleId;
}
