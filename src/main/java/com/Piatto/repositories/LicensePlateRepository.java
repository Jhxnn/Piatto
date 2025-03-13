package com.Piatto.repositories;

import com.Piatto.models.LicensePlate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LicensePlateRepository extends JpaRepository<LicensePlate, UUID> {
}
