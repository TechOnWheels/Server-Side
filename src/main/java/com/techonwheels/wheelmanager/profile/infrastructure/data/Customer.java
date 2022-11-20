package com.techonwheels.wheelmanager.profile.infrastructure.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techonwheels.wheelmanager.community.infrastructure.data.Comment;
import com.techonwheels.wheelmanager.community.infrastructure.data.Favorite;
import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Address;
import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Email;
import com.techonwheels.wheelmanager.profile.infrastructure.valueobjects.Name;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Book;
import com.techonwheels.wheelmanager.rent.infrastructure.data.Vehicle;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "customers")
@Entity
public class Customer {
    @Id
    private String customerId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName",
                    column = @Column(name = "first_name", nullable = false, length = 100)),
            @AttributeOverride(name = "secondName",
                    column = @Column(name = "second_name", nullable = false, length = 150))
    })
    private Name name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "email",
                    column = @Column(name = "email", nullable = false, length = 150))
    })
    private Email email;
    @Column(name = "dni", nullable = false, length = 12)
    private String phone;
    @Column(name = "password", nullable = false, length = 25)
    private String password;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress",
                    column = @Column(name = "street_address", nullable = false)),
            @AttributeOverride(name = "city",
                    column = @Column(name = "city_address", nullable = false, length = 50)),
            @AttributeOverride(name = "country",
                    column = @Column(name = "country_address", nullable = false, length = 50))
    })
    private Address address;
    
    @JsonIgnore
    @OneToMany(mappedBy = "ownerId")
    private Set<Vehicle> vehicles = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "bookId")
    private Set<Book> bookings = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "commentId")
    private Set<Comment> comments = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "favoriteId")
    private Set<Favorite> favorites = new HashSet<>();
}
