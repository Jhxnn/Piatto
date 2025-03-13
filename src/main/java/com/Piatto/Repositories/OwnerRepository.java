package com.Piatto.Repositories;

import com.Piatto.Models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerRepository extends JpaRepository<Owner,UUID> {
}
