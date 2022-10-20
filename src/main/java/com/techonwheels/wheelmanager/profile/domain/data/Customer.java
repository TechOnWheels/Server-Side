package com.techonwheels.wheelmanager.profile.domain.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "customers")
@Entity
public class Customer {
    @Id
    private String customerId;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "email", nullable = false, length = 150)
    private String email;
    @Column(name = "dni", nullable = false, length = 12)
    private String phone;
    @Column(name = "password", nullable = false, length = 25)
    private String password;
    @Column(name = "address", nullable = false, length = 25)
    private String address;
    @Column(name = "qualification", nullable = false)
    private Integer qualification;
}
