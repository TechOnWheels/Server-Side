package com.techonwheels.wheelmanager.rent.application.queries;

public class GetVehiclesByOwnerIdQuery {
    public String ownerId;
    
    public GetVehiclesByOwnerIdQuery(String ownerId) {
        this.ownerId = ownerId;
    }
}
