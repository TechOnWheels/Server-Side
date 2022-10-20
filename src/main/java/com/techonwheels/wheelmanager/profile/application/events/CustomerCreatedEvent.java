package com.techonwheels.wheelmanager.profile.application.events;

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
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private Integer qualification;
}
