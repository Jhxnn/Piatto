package com.Piatto.repositories;

import com.Piatto.models.OwnerImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerImageRepository extends JpaRepository<OwnerImage, UUID> {
}
