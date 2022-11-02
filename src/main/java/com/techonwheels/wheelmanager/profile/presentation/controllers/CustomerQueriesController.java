package com.techonwheels.wheelmanager.profile.presentation.controllers;

import com.techonwheels.wheelmanager.profile.application.queries.GetCustomerByIdQuery;
import com.techonwheels.wheelmanager.profile.application.queries.GetCustomersQuery;
import com.techonwheels.wheelmanager.profile.domain.dto.response.CustomerResponse;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerQueriesController {
    private final QueryGateway queryGateway;
    
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
    
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String customerId) {
        GetCustomerByIdQuery getCustomerByIdQuery = new GetCustomerByIdQuery(customerId);
        Optional<CustomerResponse> customerResponse = queryGateway.query(getCustomerByIdQuery,
                ResponseTypes.optionalInstanceOf(CustomerResponse.class)).join();
        return new ResponseEntity<CustomerResponse>(customerResponse.get(), HttpStatus.OK);
    }
}
