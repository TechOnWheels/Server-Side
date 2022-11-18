package com.techonwheels.wheelmanager.community.domain.dto.response;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FavoriteResponse {
    private String favoriteId;
    private Boolean favoriteSelected;
    private Customer favoriteCustomerId;
    private Vehicle favoriteVehicleId;
}
