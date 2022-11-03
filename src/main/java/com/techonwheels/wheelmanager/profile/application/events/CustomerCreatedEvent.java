package com.techonwheels.wheelmanager.profile.application.events;

import com.techonwheels.wheelmanager.profile.domain.valueobjects.Address;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Email;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreatedEvent {
    private String customerId;
    private Name name;
    private Email email;
    private String phone;
    private String password;
    private Address address;
    private Integer qualification;
}
