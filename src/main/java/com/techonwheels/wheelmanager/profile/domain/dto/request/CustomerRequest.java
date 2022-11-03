package com.techonwheels.wheelmanager.profile.domain.dto.request;

import com.techonwheels.wheelmanager.profile.domain.valueobjects.Address;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Email;
import com.techonwheels.wheelmanager.profile.domain.valueobjects.Name;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequest {
    private Name name;
    private Email email;
    private String phone;
    private String password;
    private Address address;
}
