package com.techonwheels.wheelmanager.profile.domain.dto.response;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Email;
import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Name;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private String customerId;
    private Name name;
    private Email email;
    private String phone;
    private String password;
    private Address address;
}
