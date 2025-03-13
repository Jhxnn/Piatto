package com.Piatto.repositories;

import com.Piatto.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerRepository extends JpaRepository<Owner,UUID> {
}
