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

    private byte image;

    public UUID getLicensePlateId() {
        return licensePlateId;
    }

    public void setLicensePlateId(UUID licensePlateId) {
        this.licensePlateId = licensePlateId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public byte getImage() {
        return image;
    }

    public void setImage(byte image) {
        this.image = image;
    }
}
