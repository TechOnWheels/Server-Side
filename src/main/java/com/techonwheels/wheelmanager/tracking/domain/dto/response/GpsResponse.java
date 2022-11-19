package com.techonwheels.wheelmanager.tracking.domain.dto.response;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GpsResponse {
    private String gpsId;
    private Double latitudeGps;
    private Double longitudeGps;
    private Address address;
    private Vehicle gpsVehicleId;
}
