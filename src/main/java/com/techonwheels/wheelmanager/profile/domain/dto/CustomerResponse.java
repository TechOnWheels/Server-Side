package com.techonwheels.wheelmanager.profile.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private Integer qualification;
}
