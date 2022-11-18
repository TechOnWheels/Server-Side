package com.techonwheels.wheelmanager.community.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FavoriteRequest {
    private Boolean favoriteSelected;
    private String favoriteCustomerId;
    private String favoriteVehicleId;
}
