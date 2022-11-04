package com.techonwheels.wheelmanager.rent.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleTypeResponse {
    private String typeId;
    private String typeName;
}
