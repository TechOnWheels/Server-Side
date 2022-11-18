package com.techonwheels.wheelmanager.community.application.handlers;

import com.techonwheels.wheelmanager.community.application.events.CommentCreatedEvent;
import com.techonwheels.wheelmanager.community.domain.repositories.CommentRepository;
import com.techonwheels.wheelmanager.community.infrastructure.data.Comment;
import com.techonwheels.wheelmanager.profile.domain.repositories.CustomerRepository;
import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleRepository;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@ProcessingGroup("comment")
public class CommentEventsHandler {
    private final CommentRepository commentRepository;
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;
    
    public CommentEventsHandler(CommentRepository commentRepository, CustomerRepository customerRepository,
                                VehicleRepository vehicleRepository) {
        this.commentRepository = commentRepository;
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
    }
    @EventHandler
    public void on(CommentCreatedEvent commentCreatedEvent) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentCreatedEvent, comment);
        Optional<Customer> customerOptional = customerRepository.findById(commentCreatedEvent.getCommentCustomerId());
        customerOptional.ifPresent(comment::setCommentCustomerId);
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(commentCreatedEvent.getCommentVehicleId());
        vehicleOptional.ifPresent(comment::setCommentVehicleId);
        commentRepository.save(comment);
    }
}
