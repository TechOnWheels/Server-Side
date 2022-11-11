package com.techonwheels.wheelmanager.profile.domain.repositories;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
