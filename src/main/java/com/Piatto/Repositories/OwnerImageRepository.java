package com.Piatto.Repositories;

import com.Piatto.Models.OwnerImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerImageRepository extends JpaRepository<OwnerImage, UUID> {
}
