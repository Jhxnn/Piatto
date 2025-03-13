package com.Piatto.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "owner_image")
public class OwnerImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID ownerImageId;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "owner")
    private Owner owner;

    public UUID getOwnerImageId() {
        return ownerImageId;
    }

    public void setOwnerImageId(UUID ownerImageId) {
        this.ownerImageId = ownerImageId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
