package com.techonwheels.wheelmanager.rent.application.projections;

import com.techonwheels.wheelmanager.profile.domain.repositories.CustomerRepository;
import com.techonwheels.wheelmanager.rent.application.queries.GetVehicleByIdQuery;
import com.techonwheels.wheelmanager.rent.application.queries.GetVehiclesByOwnerIdQuery;
import com.techonwheels.wheelmanager.rent.application.queries.GetVehiclesByTypeNameQuery;
import com.techonwheels.wheelmanager.rent.application.queries.GetVehiclesQuery;
import com.techonwheels.wheelmanager.rent.domain.dto.response.VehicleResponse;
import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleRepository;
import com.techonwheels.wheelmanager.rent.domain.repositories.VehicleTypeRepository;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class VehicleProjection {
    private final VehicleRepository vehicleRepository;
    private final VehicleTypeRepository vehicleTypeRepository;
    private final CustomerRepository customerRepository;
    
    public VehicleProjection(VehicleRepository vehicleRepository, VehicleTypeRepository vehicleTypeRepository,
                             CustomerRepository customerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleTypeRepository = vehicleTypeRepository;
        this.customerRepository = customerRepository;
    }
    
    @QueryHandler
    public List<VehicleResponse> on(GetVehiclesQuery getVehiclesQuery) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        
        List<VehicleResponse> vehicleResponses = vehicles.stream()
                .map(vehicle -> VehicleResponse
                        .builder()
                        .vehicleId(vehicle.getVehicleId())
                        .vehicleName(vehicle.getVehicleName())
                        .imageURL(vehicle.getImageURL())
                        .description(vehicle.getDescription())
                        .price(vehicle.getPrice())
                        .qualification(vehicle.getQualification())
                        .status(vehicle.getStatus())
                        .brand(vehicle.getBrand())
                        .vehicleTypeId(vehicle.getVehicleTypeId())
                        .ownerId(vehicle.getOwnerId())
                        .build())
                .collect(Collectors.toList());
        return vehicleResponses;
    }
    
    @QueryHandler
    public Optional<VehicleResponse> on(GetVehicleByIdQuery getVehicleByIdQuery) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(getVehicleByIdQuery.vehicleId);
        Optional<VehicleResponse> vehicleResponse = vehicle.map(vehicleResponse1 -> VehicleResponse
                .builder()
                .vehicleId(vehicleResponse1.getVehicleId())
                .vehicleName(vehicleResponse1.getVehicleName())
                .imageURL(vehicleResponse1.getImageURL())
                .description(vehicleResponse1.getDescription())
                .price(vehicleResponse1.getPrice())
                .qualification(vehicleResponse1.getQualification())
                .status(vehicleResponse1.getStatus())
                .brand(vehicleResponse1.getBrand())
                .vehicleTypeId(vehicleResponse1.getVehicleTypeId())
                .ownerId(vehicleResponse1.getOwnerId())
                .build());
        return vehicleResponse;
    }
    
    @QueryHandler
    public List<VehicleResponse> on(GetVehiclesByTypeNameQuery getVehiclesByTypeNameQuery) {
        List<Vehicle> vehicles =
                vehicleRepository.findVehiclesByVehicleTypeId(vehicleTypeRepository.findByTypeName(getVehiclesByTypeNameQuery.typeName).get());
        
        List<VehicleResponse> vehicleResponses = vehicles.stream()
                .map(vehicle -> VehicleResponse
                        .builder()
                        .vehicleId(vehicle.getVehicleId())
                        .vehicleName(vehicle.getVehicleName())
                        .imageURL(vehicle.getImageURL())
                        .description(vehicle.getDescription())
                        .price(vehicle.getPrice())
                        .qualification(vehicle.getQualification())
                        .status(vehicle.getStatus())
                        .brand(vehicle.getBrand())
                        .vehicleTypeId(vehicle.getVehicleTypeId())
                        .ownerId(vehicle.getOwnerId())
                        .build())
                .collect(Collectors.toList());
        return vehicleResponses;
    }
    
    @QueryHandler
    public List<VehicleResponse> on(GetVehiclesByOwnerIdQuery getVehiclesByOwnerIdQuery) {
        List<Vehicle> vehicles =
                vehicleRepository.findVehiclesByOwnerId(customerRepository.findById(getVehiclesByOwnerIdQuery.ownerId).get());
        
        List<VehicleResponse> vehicleResponses = vehicles.stream()
                .map(vehicle -> VehicleResponse
                        .builder()
                        .vehicleId(vehicle.getVehicleId())
                        .vehicleName(vehicle.getVehicleName())
                        .imageURL(vehicle.getImageURL())
                        .description(vehicle.getDescription())
                        .price(vehicle.getPrice())
                        .qualification(vehicle.getQualification())
                        .status(vehicle.getStatus())
                        .brand(vehicle.getBrand())
                        .vehicleTypeId(vehicle.getVehicleTypeId())
                        .ownerId(vehicle.getOwnerId())
                        .build())
                .collect(Collectors.toList());
        return vehicleResponses;
    }
}
