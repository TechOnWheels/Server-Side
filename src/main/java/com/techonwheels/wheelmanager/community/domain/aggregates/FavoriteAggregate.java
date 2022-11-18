package com.techonwheels.wheelmanager.community.domain.aggregates;

import com.techonwheels.wheelmanager.community.application.commands.CreateFavoriteCommand;
import com.techonwheels.wheelmanager.community.application.events.FavoriteCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class FavoriteAggregate {
    @AggregateIdentifier
    private String favoriteId;
    private Boolean favoriteSelected;
    private String favoriteCustomerId;
    private String favoriteVehicleId;
    
    public FavoriteAggregate() {
    }
    
    @CommandHandler
    public FavoriteAggregate(CreateFavoriteCommand createFavoriteCommand) {
        FavoriteCreatedEvent favoriteCreatedEvent = new FavoriteCreatedEvent();
        BeanUtils.copyProperties(createFavoriteCommand, favoriteCreatedEvent);
        AggregateLifecycle.apply(favoriteCreatedEvent);
    }
    
    @EventSourcingHandler
    public void on(FavoriteCreatedEvent favoriteCreatedEvent) {
        this.favoriteId = favoriteCreatedEvent.getFavoriteId();
        this.favoriteSelected = favoriteCreatedEvent.getFavoriteSelected();
        this.favoriteCustomerId = favoriteCreatedEvent.getFavoriteCustomerId();
        this.favoriteVehicleId = favoriteCreatedEvent.getFavoriteVehicleId();
    }
}
