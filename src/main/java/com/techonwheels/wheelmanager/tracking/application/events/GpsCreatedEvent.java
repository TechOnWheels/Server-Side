package com.techonwheels.wheelmanager.tracking.application.events;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GpsCreatedEvent {
    private String gpsId;
    private Double latitudeGps;
    private Double longitudeGps;
    private Address addressGps;
    private String gpsVehicleOwnerId;
}
