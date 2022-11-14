package com.techonwheels.wheelmanager.rent.application.queries;

public class GetBookingsByCustomerIdQuery {
    public String customerId;
    
    public GetBookingsByCustomerIdQuery(String customerId) {
        this.customerId = customerId;
    }
}
