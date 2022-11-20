package com.techonwheels.wheelmanager.rent.application.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleTypeCreatedEvent {
    private String typeId;
    private String typeName;
}
