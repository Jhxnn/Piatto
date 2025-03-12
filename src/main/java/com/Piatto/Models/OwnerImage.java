package com.Piatto.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "owner_image")
public class OwnerImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID ownerImageId;

    private byte image;

    private Owner owner;
}
