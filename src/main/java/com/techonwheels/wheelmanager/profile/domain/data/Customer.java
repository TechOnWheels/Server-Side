package com.techonwheels.wheelmanager.profile.domain.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @Id
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private Integer qualification;
}
