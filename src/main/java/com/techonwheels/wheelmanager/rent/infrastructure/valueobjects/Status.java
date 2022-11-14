package com.techonwheels.wheelmanager.rent.infrastructure.valueobjects;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Status {
    private String statusVehicle;
}
