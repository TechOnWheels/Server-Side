package com.techonwheels.wheelmanager.profile.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequest {
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private Integer qualification;
}
