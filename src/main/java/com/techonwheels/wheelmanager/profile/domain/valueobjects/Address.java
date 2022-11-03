package com.techonwheels.wheelmanager.profile.domain.valueobjects;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String streetAddress;
    private String city;
    private String country;
}