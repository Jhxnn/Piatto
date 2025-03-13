package com.Piatto.Models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "license_plate")
public class LicensePlate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID licensePlateId;

    private String licensePlate;

}
