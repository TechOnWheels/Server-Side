package com.techonwheels.wheelmanager.rent.domain.valueobjects;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Brand {
    private String brandName;
}
