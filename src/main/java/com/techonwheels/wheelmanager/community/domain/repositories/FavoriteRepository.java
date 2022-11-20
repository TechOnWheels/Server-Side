package com.techonwheels.wheelmanager.community.domain.repositories;

import com.techonwheels.wheelmanager.community.infrastructure.data.Favorite;
import com.techonwheels.wheelmanager.profile.infrastructure.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, String> {
    List<Favorite> findFavoritesByFavoriteCustomerId(Customer favoriteCustomerId);
}
