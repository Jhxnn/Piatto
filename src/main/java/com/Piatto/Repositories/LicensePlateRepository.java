package com.Piatto.Repositories;

import com.Piatto.Models.LicensePlate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LicensePlateRepository extends JpaRepository<UUID, LicensePlate> {
}
