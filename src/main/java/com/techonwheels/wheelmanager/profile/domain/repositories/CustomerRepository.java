package com.techonwheels.wheelmanager.profile.domain.repositories;

import com.techonwheels.wheelmanager.profile.domain.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
