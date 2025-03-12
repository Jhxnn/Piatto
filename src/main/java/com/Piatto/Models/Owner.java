package com.Piatto.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ownerId;

    private String cpf;

    private String name;

    private LocalDate bornedAt;


}
