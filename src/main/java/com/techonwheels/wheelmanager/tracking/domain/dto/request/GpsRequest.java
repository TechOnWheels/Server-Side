package com.techonwheels.wheelmanager.tracking.domain.dto.request;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GpsRequest {
    private Double latitudeGps;
    private Double longitudeGps;
    private Address addressGps;
    private String gpsVehicleOwnerId;
}
