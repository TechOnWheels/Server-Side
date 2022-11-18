package com.techonwheels.wheelmanager.community.application.handlers;

import com.techonwheels.wheelmanager.community.application.events.FavoriteCreatedEvent;
import com.techonwheels.wheelmanager.community.domain.repositories.FavoriteRepository;
import com.techonwheels.wheelmanager.community.infrastructure.data.Favorite;
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
@ProcessingGroup("favorite")
public class FavoriteEventsHandler {
    private final FavoriteRepository favoriteRepository;
    private final CustomerRepository customerRepository;
    private final VehicleRepository vehicleRepository;
    
    public FavoriteEventsHandler(FavoriteRepository favoriteRepository, CustomerRepository customerRepository,
                                 VehicleRepository vehicleRepository) {
        this.favoriteRepository = favoriteRepository;
        this.customerRepository = customerRepository;
        this.vehicleRepository = vehicleRepository;
    }
    
    @EventHandler
    public void on(FavoriteCreatedEvent favoriteCreatedEvent) {
        Favorite favorite = new Favorite();
        BeanUtils.copyProperties(favoriteCreatedEvent, favorite);
        Optional<Customer> customerOptional = customerRepository.findById(favoriteCreatedEvent.getFavoriteCustomerId());
        customerOptional.ifPresent(favorite::setFavoriteCustomerId);
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(favoriteCreatedEvent.getFavoriteVehicleId());
        vehicleOptional.ifPresent(favorite::setFavoriteVehicleId);
        favoriteRepository.save(favorite);
    }
}
