package org.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString(exclude = {"roles", "address"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "User_Role",
            joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "role_id")}
    )
    private Set<Role> roles;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;

    @OneToMany(mappedBy = "user")
    private Set<Rental> rentals;
}
