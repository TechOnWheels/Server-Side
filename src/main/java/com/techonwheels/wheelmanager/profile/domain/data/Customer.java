package com.techonwheels.wheelmanager.profile.domain.data;

import com.techonwheels.wheelmanager.profile.domain.valueobjects.Address;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Email;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Name;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "customers")
@Entity
public class Customer {
    @Id
    private String customerId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName",
                    column = @Column(name = "first_name", nullable = false, length = 100)),
            @AttributeOverride(name = "secondName",
                    column = @Column(name = "second_name", nullable = false, length = 150))
    })
    private Name name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "email",
                    column = @Column(name = "email", nullable = false, length = 150))
    })
    private Email email;
    @Column(name = "dni", nullable = false, length = 12)
    private String phone;
    @Column(name = "password", nullable = false, length = 25)
    private String password;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress",
                    column = @Column(name = "street_address", nullable = false)),
            @AttributeOverride(name = "city",
                    column = @Column(name = "city_address", nullable = false, length = 50)),
            @AttributeOverride(name = "country",
                    column = @Column(name = "country_address", nullable = false, length = 50))
    })
    private Address address;
}
