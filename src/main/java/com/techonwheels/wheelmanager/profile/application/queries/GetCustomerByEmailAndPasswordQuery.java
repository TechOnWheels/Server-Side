package com.techonwheels.wheelmanager.profile.application.queries;

import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Email;

public class GetCustomerByEmailAndPasswordQuery {
    public Email email;
    public String password;
    
    public GetCustomerByEmailAndPasswordQuery(Email email, String password) {
        this.password = password;
        this.email = email;
    }
}
