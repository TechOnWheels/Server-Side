package com.techonwheels.wheelmanager.rent.presentation.rest.controllers;

import com.techonwheels.wheelmanager.rent.application.queries.GetVehicleByIdQuery;
import com.techonwheels.wheelmanager.rent.application.queries.GetVehiclesByOwnerIdQuery;
import com.techonwheels.wheelmanager.rent.application.queries.GetVehiclesByTypeNameQuery;
import com.techonwheels.wheelmanager.rent.application.queries.GetVehiclesQuery;
import com.techonwheels.wheelmanager.rent.domain.dto.response.VehicleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Tag(name = "Vehicles Queries")
@RestController
@RequestMapping("/api/vehicles")
public class VehicleQueriesController {
    private final QueryGateway queryGateway;
    
    public VehicleQueriesController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }
    
    @GetMapping
    @Operation(summary = "Get All Vehicles")
    public List<VehicleResponse> getAllVehicles() {
        GetVehiclesQuery getVehiclesQuery = new GetVehiclesQuery();
        List<VehicleResponse> vehicleResponses = queryGateway.query(getVehiclesQuery,
                ResponseTypes.multipleInstancesOf(VehicleResponse.class)).join();
        return vehicleResponses;
    }
    
    @GetMapping("/{vehicleId}")
    @Operation(summary = "Gget Vehicle By Id")
    public ResponseEntity<VehicleResponse> getVehicleById(@PathVariable String vehicleId) {
        GetVehicleByIdQuery getVehicleByIdQuery = new GetVehicleByIdQuery(vehicleId);
        Optional<VehicleResponse> vehicleResponse = queryGateway.query(getVehicleByIdQuery,
                ResponseTypes.optionalInstanceOf(VehicleResponse.class)).join();
        return new ResponseEntity<VehicleResponse>(vehicleResponse.get(), HttpStatus.OK);
    }
    
    @GetMapping("/filter")
    @Operation(summary = "Get All Vehicles By Type Name")
    public List<VehicleResponse> getAllVehiclesByTypeName(@RequestParam(name = "vehicleTypeName") String vehicleTypeName) {
        GetVehiclesByTypeNameQuery getVehiclesByTypeNameQuery = new GetVehiclesByTypeNameQuery(vehicleTypeName);
        List<VehicleResponse> vehicleResponses = queryGateway.query(getVehiclesByTypeNameQuery,
                ResponseTypes.multipleInstancesOf(VehicleResponse.class)).join();
        return vehicleResponses;
    }
    
    @GetMapping("/owner/{ownerId}")
    @Operation(summary = "Get All Vehicles By Owner Id")
    public List<VehicleResponse> getAllVehiclesByOwnerId(@PathVariable String ownerId) {
        GetVehiclesByOwnerIdQuery getVehiclesByOwnerIdQuery = new GetVehiclesByOwnerIdQuery(ownerId);
        List<VehicleResponse> vehicleResponses = queryGateway.query(getVehiclesByOwnerIdQuery,
                ResponseTypes.multipleInstancesOf(VehicleResponse.class)).join();
        return vehicleResponses;
    }
    
}
