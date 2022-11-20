package com.techonwheels.wheelmanager.community.presentation.rest.controllers;

import com.techonwheels.wheelmanager.community.application.commands.CreateFavoriteCommand;
import com.techonwheels.wheelmanager.community.domain.dto.request.FavoriteRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin
@Tag(name = "Favorites Commands")
@RestController
@RequestMapping("/api/favorites")
public class FavoriteCommandsController {
    private final CommandGateway commandGateway;
    
    public FavoriteCommandsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    
    @PostMapping
    @Operation(summary = "Post Favorite")
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
