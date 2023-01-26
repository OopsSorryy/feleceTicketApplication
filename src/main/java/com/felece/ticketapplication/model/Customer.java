package com.felece.ticketapplication.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String email;

    private String password;

    private String matchingPassword;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Customer(String email, String password, String matchingPassword, String firstName, String lastName, Role role) {
        this.email = email;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
