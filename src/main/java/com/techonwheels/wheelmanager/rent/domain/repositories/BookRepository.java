package com.techonwheels.wheelmanager.rent.domain.repositories;

import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findBooksByBookCustomerId(Customer bookCustomerId);
}
