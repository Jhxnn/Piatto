package com.Piatto.dtos;

//import com.Piatto.Models.LicensePlate;

import java.time.LocalDate;
import java.util.UUID;

public record OwnerDto(String cpf, String name, UUID licensePlate, LocalDate bornedAt) {
}
