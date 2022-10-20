package com.techonwheels.wheelmanager.profile.presentation.queries.controller;

import com.techonwheels.wheelmanager.profile.application.queries.GetCustomersQuery;
import com.techonwheels.wheelmanager.profile.domain.dto.CustomerResponse;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerQueriesController {
    private QueryGateway queryGateway;
    
    public CustomerQueriesController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
    
    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        GetCustomersQuery getCustomersQuery = new GetCustomersQuery();
        List<CustomerResponse> customerResponses = queryGateway.query(getCustomersQuery,
                ResponseTypes.multipleInstancesOf(CustomerResponse.class)).join();
        return customerResponses;
    }
}
