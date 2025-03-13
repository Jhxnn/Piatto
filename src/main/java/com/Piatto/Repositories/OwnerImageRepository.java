package com.Piatto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerImageRepository extends JpaRepository<UUID, OwnerImageRepository> {
}
