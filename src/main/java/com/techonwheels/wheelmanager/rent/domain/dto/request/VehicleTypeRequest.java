package com.techonwheels.wheelmanager.rent.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class VehicleTypeRequest {
    private String typeName;
    
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public VehicleTypeRequest(@JsonProperty("typeName") String typeName) {
        this.typeName = typeName;
    }
}
