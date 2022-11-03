package com.techonwheels.wheelmanager.profile.domain.valueobjects;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Email {
    private String email;
}
