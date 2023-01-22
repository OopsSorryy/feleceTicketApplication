package com.felece.ticketapplication.model;


import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class BaseUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String email;

    private String password;

    private String matchingPassword;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;
}
