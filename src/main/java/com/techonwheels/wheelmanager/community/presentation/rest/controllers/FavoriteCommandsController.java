package com.techonwheels.wheelmanager.community.presentation.rest.controllers;

import com.techonwheels.wheelmanager.community.application.commands.CreateFavoriteCommand;
import com.techonwheels.wheelmanager.community.domain.dto.request.FavoriteRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteCommandsController {
    private final CommandGateway commandGateway;
    
    public FavoriteCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    public String addFavorite(@RequestBody FavoriteRequest favoriteRequest) {
        CreateFavoriteCommand createFavoriteCommand =
                CreateFavoriteCommand
                        .builder()
                        .favoriteId(UUID.randomUUID().toString())
                        .favoriteSelected(favoriteRequest.getFavoriteSelected())
                        .favoriteCustomerId(favoriteRequest.getFavoriteCustomerId())
                        .favoriteVehicleId(favoriteRequest.getFavoriteVehicleId())
                        .build();
        String result = commandGateway.sendAndWait(createFavoriteCommand);
        return result;
    }
}
